package com.arturszymanski.chargingstats.view.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.devpanther.presenter.base.BaseView

abstract class BaseFragment<VB : ViewBinding> : Fragment(), BaseView {

    private var _binding: VB? = null
    val binding: VB
        get() = requireNotNull(_binding)

    override fun onAttach(context: Context) {
        injectDependencies()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = createViewBinding(inflater, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            view.findNavController()
        } catch (e: IllegalStateException) {
            Navigation.setViewNavController(view, findNavController())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VB

    /**
     * Method that invoke inject dependencies in right moment
     */
    abstract fun injectDependencies()

    fun Fragment.popBackstackOrFinishActivity() {
        if (!findNavController().popBackStack() && activity is BaseActivity<*>) {
            activity?.finishAfterTransition()
        }
    }
}