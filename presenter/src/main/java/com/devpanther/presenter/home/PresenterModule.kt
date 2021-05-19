package com.devpanther.presenter.home

import androidx.lifecycle.ViewModel
import com.devpanther.presenter.base.PresenterFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Provider

const val HOME_PRESENTER_FACTORY: String = "HPF"

@Module
class PresenterModule {

    @Named(HOME_PRESENTER_FACTORY)
    @Provides
    fun provideRepositoryListPresenterFactory(
        presenterProvider: Provider<HomePresenter>
    ): PresenterFactory =
        object : PresenterFactory() {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> createPresenter(presenterClass: Class<T>): T {
                return presenterProvider.get() as T
            }
        }
}