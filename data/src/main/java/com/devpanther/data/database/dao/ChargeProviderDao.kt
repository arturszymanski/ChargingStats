package com.devpanther.data.database.dao

import androidx.room.*
import com.devpanther.data.database.model.table.ChargeProviderTable
import java.util.*

@Dao
interface ChargeProviderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg chargeProviderTable: ChargeProviderTable)

    @Delete
    fun deleteAll(vararg chargeProviderTable: ChargeProviderTable)

    @Query("SELECT * FROM charge_provider_table")
    fun getAll(): List<ChargeProviderTable>

    @Query("SELECT * FROM charge_provider_table WHERE id = :id")
    fun get(id: UUID): ChargeProviderTable
}