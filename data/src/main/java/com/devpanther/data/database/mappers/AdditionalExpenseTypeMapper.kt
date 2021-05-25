package com.devpanther.data.database.mappers

import com.devpanther.data.database.model.table.AdditionalExpensesTypeTable
import com.devpanther.domaindata.database.dto.AdditionalExpenseTypeDTO

fun AdditionalExpenseTypeDTO.toEntity() =
    AdditionalExpensesTypeTable(
        id = id,
        name = name
    )

fun AdditionalExpensesTypeTable.toDTO() =
    AdditionalExpenseTypeDTO(
        id = id,
        name = name
    )
