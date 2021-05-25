package com.devpanther.data.database.mappers

import com.devpanther.data.database.model.relations.AdditionalExpenseDB
import com.devpanther.data.database.model.table.AdditionalExpenseTable
import com.devpanther.domaindata.database.dto.AdditionalExpenseDTO
import java.util.*

fun AdditionalExpenseDTO.toEntity(chargeInfoId: UUID) =
    AdditionalExpenseTable(
        id = id,
        expenses = expenses,
        chargeInfoId = chargeInfoId,
        typeId = type.id
    )

fun AdditionalExpenseDB.toDTO() =
    AdditionalExpenseDTO(
        id = additionalExpenseTable.id,
        expenses = additionalExpenseTable.expenses,
        type = type.toDTO()
    )