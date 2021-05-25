package com.devpanther.data.database.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.devpanther.data.database.model.table.AdditionalExpenseTable
import com.devpanther.data.database.model.table.AdditionalExpensesTypeTable

data class AdditionalExpenseDB(
    @Embedded
    val additionalExpenseTable: AdditionalExpenseTable,
    @Relation(
        parentColumn = "type_id",
        entityColumn = "id"
    )
    val type: AdditionalExpensesTypeTable
)
