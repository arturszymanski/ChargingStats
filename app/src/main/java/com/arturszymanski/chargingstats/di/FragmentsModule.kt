package com.arturszymanski.chargingstats.di

import com.arturszymanski.chargingstats.view.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment
}