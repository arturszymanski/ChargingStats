package com.devpanther.domain.mappers

import com.devpanther.domain.model.AdditionalExpenseModel
import com.devpanther.domaindata.database.dto.AdditionalExpenseDTO

fun AdditionalExpenseDTO.toEntity() =
    AdditionalExpenseModel(
        id = id,
        expenses = expenses,
        type = type.toEntity()
    )

fun AdditionalExpenseModel.toDTO() =
    AdditionalExpenseDTO(
        id = id,
        expenses = expenses,
        type = type.toDTO()
    )