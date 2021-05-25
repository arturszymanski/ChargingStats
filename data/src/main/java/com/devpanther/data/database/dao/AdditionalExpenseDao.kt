package com.devpanther.data.database.dao

import androidx.room.*
import com.devpanther.data.database.model.relations.AdditionalExpenseDB
import com.devpanther.data.database.model.table.AdditionalExpenseTable
import java.util.*

@Dao
interface AdditionalExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg additionalExpenseTable: AdditionalExpenseTable)

    @Delete
    fun deleteAll(vararg additionalExpenseTable: AdditionalExpenseTable)

    @Query("SELECT * FROM additional_expense_table")
    fun getAll(): List<AdditionalExpenseTable>

    @Query("SELECT * FROM additional_expense_table WHERE id = :id")
    fun get(id: UUID): AdditionalExpenseTable

    @Transaction
    @Query("SELECT * FROM additional_expense_table WHERE id = :id")
    fun getDB(id: UUID): AdditionalExpenseDB
}