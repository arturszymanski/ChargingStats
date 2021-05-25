package com.devpanther.data.database.dao

import androidx.room.*
import com.devpanther.data.database.model.relations.ChargePointDB
import com.devpanther.data.database.model.table.ChargePointTable
import java.util.*

@Dao
interface ChargePointDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg chargePointTable: ChargePointTable)

    @Delete
    fun deleteAll(vararg chargePointTable: ChargePointTable)

    @Query("SELECT * FROM charge_point_table")
    fun getAll(): List<ChargePointTable>

    @Query("SELECT * FROM charge_point_table WHERE id = :id")
    fun get(id: UUID): ChargePointTable

    @Transaction
    @Query("SELECT * FROM charge_point_table WHERE id = :id")
    fun getDB(id: UUID): ChargePointDB
}