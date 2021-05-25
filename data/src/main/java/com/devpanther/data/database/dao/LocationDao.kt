package com.devpanther.data.database.dao

import androidx.room.*
import com.devpanther.data.database.model.table.LocationTable
import java.util.*

@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg locationTable: LocationTable)

    @Delete
    fun deleteAll(vararg locationTable: LocationTable)

    @Query("SELECT * FROM location_table")
    fun getAll(): List<LocationTable>

    @Query("SELECT * FROM location_table WHERE id = :id")
    fun get(id: UUID): LocationTable
}