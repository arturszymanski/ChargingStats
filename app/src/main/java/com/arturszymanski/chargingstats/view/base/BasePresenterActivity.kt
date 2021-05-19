package com.arturszymanski.chargingstats.view.base

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.devpanther.presenter.base.BasePresenter
import com.devpanther.presenter.base.BaseView
import com.devpanther.presenter.base.PresenterFactory

/**
 * Base Activity that adds support for presenter and allow to keep state of this presenter. Also handles basis
 * presenter methods and needs.
 */
abstract class BasePresenterActivity<P, V, VB> :
    BaseActivity<VB>() where V : BaseView, P : BasePresenter<V>, VB : ViewBinding {
    /**
     * Instance of presenter.
     */
    lateinit var presenter: P

    /**
     * Instance of presenter factory that allow to create presenter and check if was previously created.
     */
    private lateinit var presenterFactory: PresenterFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenterFactory = prepareFactory()

        presenter = ViewModelProvider(this, presenterFactory).get(presenterClass())
        onPresenterPrepared(fromStorage = !presenterFactory.isNewCreated)
    }

    override fun onStart() {
        super.onStart()

        if (::presenter.isInitialized) {
            @Suppress("UNCHECKED_CAST")
            presenter.bind(this as V)
        }
    }

    override fun onStop() {
        if (::presenter.isInitialized) {
            presenter.unbind()
        }

        super.onStop()
    }

    /**
     * Invoked when presenter was prepared and ready for use in this view. Might be used to setup initial presenter
     * parameters, eg. from Bundle
     * @param fromStorage inform if presenter was created (fromStorage = false) or restored (fromStorage = true)
     */
    abstract fun onPresenterPrepared(fromStorage: Boolean)

    /**
     * Method needed to create instance of presenter.
     * @return Return class of presenter used by this view. eg. BasePresenter::class.java
     */
    abstract fun presenterClass(): Class<P>

    /**
     * Method that create presenter factory that will be used to create presenter.
     * @return PresenterFactory that will be used to create presenter.
     */
    abstract fun prepareFactory(): PresenterFactory
}