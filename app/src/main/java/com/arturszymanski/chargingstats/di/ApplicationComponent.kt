package com.arturszymanski.chargingstats.di

import android.content.Context
import com.arturszymanski.chargingstats.ChargingStatsApplication
import com.devpanther.domain.di.DataSourceModule
import com.devpanther.presenter.home.PresenterModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (AndroidInjectionModule::class),
        (ActivitiesModule::class),
        (FragmentsModule::class),
        (UiModule::class),
        (DataSourceModule::class),
        (PresenterModule::class)
    ]
)
interface ApplicationComponent {

    fun inject(application: ChargingStatsApplication)

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun context(context: Context): Builder
    }
}