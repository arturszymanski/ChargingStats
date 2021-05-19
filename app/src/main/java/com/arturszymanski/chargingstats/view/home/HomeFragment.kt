package com.arturszymanski.chargingstats.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.arturszymanski.chargingstats.databinding.FragmentHomeBinding
import com.arturszymanski.chargingstats.view.base.BasePresenterFragment
import com.devpanther.presenter.base.PresenterFactory
import com.devpanther.presenter.home.HOME_PRESENTER_FACTORY
import com.devpanther.presenter.home.HomePresenter
import com.devpanther.presenter.home.HomeView
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Provider

class HomeFragment : BasePresenterFragment<HomePresenter, HomeView, FragmentHomeBinding>() {

    @Named(HOME_PRESENTER_FACTORY)
    @Inject
    lateinit var presenterFactoryProvider: Provider<PresenterFactory>

    //region BasePresenterFragment
    override fun onPresenterPrepared(fromStorage: Boolean) {}

    override fun presenterClass(): Class<HomePresenter> =
        HomePresenter::class.java

    override fun prepareFactory(): PresenterFactory =
        presenterFactoryProvider.get()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding =
        FragmentHomeBinding.inflate(inflater, container, false)

    override fun injectDependencies() {
        AndroidSupportInjection.inject(this)
    }
    //endregion
}