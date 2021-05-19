package com.arturszymanski.chargingstats.view.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.devpanther.presenter.base.BaseView

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(), BaseView {

    private var _binding: VB? = null
    val binding: VB
        get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        _binding = createViewBinding(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    abstract fun createViewBinding(
        inflater: LayoutInflater
    ): VB

    /**
     * Method that invoke inject dependencies in right moment
     */
    abstract fun injectDependencies()
}