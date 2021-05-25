package com.devpanther.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.devpanther.data.database.converters.BigDecimalConverter
import com.devpanther.data.database.converters.UUIDConverter
import com.devpanther.data.database.dao.*
import com.devpanther.data.database.model.table.*

@Database(
    version = 1,
    entities = [
        AdditionalExpensesTypeTable::class,
        AdditionalExpenseTable::class,
        AddressTable::class,
        ChargeInfoTable::class,
        ChargePointTable::class,
        ChargeProviderTable::class,
        LocationTable::class,
        MeasureInfoTable::class
    ],
    exportSchema = true,
)
@TypeConverters(
    UUIDConverter::class,
    BigDecimalConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun additionalExpenseDao(): AdditionalExpenseDao

    abstract fun additionalExpenseTypeDao(): AdditionalExpenseTypeDao

    abstract fun addressDao(): AddressDao

    abstract fun chargeInfoDao(): ChargeInfoDao

    abstract fun chargePointDao(): ChargePointDao

    abstract fun chargeProviderDao(): ChargeProviderDao

    abstract fun locationDao(): LocationDao

    abstract fun measureInfoDao(): MeasureInfoDao
}