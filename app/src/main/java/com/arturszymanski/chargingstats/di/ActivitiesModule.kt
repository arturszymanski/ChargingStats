package com.arturszymanski.chargingstats.di

import com.arturszymanski.chargingstats.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}