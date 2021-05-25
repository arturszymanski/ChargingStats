package com.devpanther.data.database.dao

import androidx.room.*
import com.devpanther.data.database.model.table.MeasureInfoTable
import java.util.*

@Dao
interface MeasureInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg measureInfoTable: MeasureInfoTable)

    @Delete
    fun deleteAll(vararg measureInfoTable: MeasureInfoTable)

    @Query("SELECT * FROM measure_info_table")
    fun getAll(): List<MeasureInfoTable>

    @Query("SELECT * FROM measure_info_table WHERE id = :id")
    fun get(id: UUID): MeasureInfoTable
}