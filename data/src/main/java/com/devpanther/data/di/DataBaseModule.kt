package com.devpanther.data.di

import android.content.Context
import androidx.room.Room
import com.devpanther.data.BuildConfig
import com.devpanther.data.database.AppDatabase
import com.devpanther.data.database.DataBaseDataImpl
import com.devpanther.data.database.dao.*
import com.devpanther.domaindata.database.DataBaseData
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Provides
    fun provideDataBaseName(): String =
        BuildConfig.DB_NAME

    @Singleton
    @Provides
    fun provideAppDataBase(
        context: Context,
        dbName: String
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            dbName
        ).build()

    @Provides
    fun additionalExpenseDao(appDatabase: AppDatabase): AdditionalExpenseDao =
        appDatabase.additionalExpenseDao()

    @Provides
    fun additionalExpenseTypeDao(appDatabase: AppDatabase): AdditionalExpenseTypeDao =
        appDatabase.additionalExpenseTypeDao()

    @Provides
    fun addressDao(appDatabase: AppDatabase): AddressDao =
        appDatabase.addressDao()

    @Provides
    fun chargeInfoDao(appDatabase: AppDatabase): ChargeInfoDao =
        appDatabase.chargeInfoDao()

    @Provides
    fun chargePointDao(appDatabase: AppDatabase): ChargePointDao =
        appDatabase.chargePointDao()

    @Provides
    fun chargeProviderDao(appDatabase: AppDatabase): ChargeProviderDao =
        appDatabase.chargeProviderDao()

    @Provides
    fun locationDao(appDatabase: AppDatabase): LocationDao =
        appDatabase.locationDao()

    @Provides
    fun measureInfoDao(appDatabase: AppDatabase): MeasureInfoDao =
        appDatabase.measureInfoDao()

    @Provides
    fun provideDataBaseData(dataBaseDataImpl: DataBaseDataImpl): DataBaseData =
        dataBaseDataImpl
}