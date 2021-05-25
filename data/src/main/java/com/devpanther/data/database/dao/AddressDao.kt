package com.devpanther.data.database.dao

import androidx.room.*
import com.devpanther.data.database.model.relations.AddressDB
import com.devpanther.data.database.model.table.AddressTable
import java.util.*

@Dao
interface AddressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg addressTable: AddressTable)

    @Delete
    fun deleteAll(vararg addressTable: AddressTable)

    @Query("SELECT * FROM address_table")
    fun getAll(): List<AddressTable>

    @Query("SELECT * FROM address_table WHERE id = :id")
    fun get(id: UUID): AddressTable

    @Transaction
    @Query("SELECT * FROM address_table WHERE id = :id")
    fun getDB(id: UUID): AddressDB
}