package com.devpanther.domain.mappers

import com.devpanther.domain.model.AdditionalExpensesTypeModel
import com.devpanther.domaindata.database.dto.AdditionalExpenseTypeDTO

fun AdditionalExpenseTypeDTO.toEntity() =
    AdditionalExpensesTypeModel(
        id = id,
        name = name
    )

fun AdditionalExpensesTypeModel.toDTO() =
    AdditionalExpenseTypeDTO(
        id = id,
        name = name
    )
