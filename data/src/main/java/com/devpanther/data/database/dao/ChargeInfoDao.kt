package com.devpanther.data.database.dao

import androidx.room.*
import com.devpanther.data.database.model.relations.ChargeInfoDB
import com.devpanther.data.database.model.table.ChargeInfoTable
import java.util.*

@Dao
interface ChargeInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg chargeInfoTable: ChargeInfoTable)

    @Delete
    fun deleteAll(vararg chargeInfoTable: ChargeInfoTable)

    @Query("SELECT * FROM charge_info_table")
    fun getAll(): List<ChargeInfoTable>

    @Transaction
    @Query("SELECT * FROM charge_info_table")
    fun getAllDB(): List<ChargeInfoDB>

    @Query("SELECT * FROM charge_info_table WHERE id = :id")
    fun get(id: UUID): ChargeInfoTable

    @Transaction
    @Query("SELECT * FROM charge_info_table WHERE id = :id")
    fun getDB(id: UUID): ChargeInfoDB
}