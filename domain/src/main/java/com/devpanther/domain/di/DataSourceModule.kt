package com.devpanther.domain.di

import com.devpanther.domain.datasource.ChargeInfoDataSource
import com.devpanther.domain.datasource.ChargeInfoDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {
    @Binds
    abstract fun bindChargeInfoDataSource(
        chargeInfoDataSourceImpl: ChargeInfoDataSourceImpl
    ): ChargeInfoDataSource
}