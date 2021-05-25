package com.devpanther.data.database.dao

import androidx.room.*
import com.devpanther.data.database.model.table.AdditionalExpensesTypeTable
import java.util.*

@Dao
interface AdditionalExpenseTypeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg additionalExpensesTypeTable: AdditionalExpensesTypeTable)

    @Delete
    fun deleteAll(vararg additionalExpensesTypeTable: AdditionalExpensesTypeTable)

    @Query("SELECT * FROM additional_expenses_type_table")
    fun getAll(): List<AdditionalExpensesTypeTable>

    @Query("SELECT * FROM additional_expenses_type_table WHERE id = :id")
    fun get(id: UUID): AdditionalExpensesTypeTable
}