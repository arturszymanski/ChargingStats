package com.devpanther.data.database.model.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.*

@Entity(tableName = "additional_expense_table")
data class AdditionalExpenseTable(
    @PrimaryKey(autoGenerate = false) val id: UUID,
    @ColumnInfo(name = "type_id") val typeId: UUID,
    @ColumnInfo(name = "expenses") val expenses: BigDecimal,
    @ColumnInfo(name = "charge_info_id") val chargeInfoId: UUID
)