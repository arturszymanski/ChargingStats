package com.devpanther.domaindata.database.dto

import java.math.BigDecimal
import java.util.*

data class AdditionalExpenseDTO(
    val id: UUID,
    val type: AdditionalExpenseTypeDTO,
    val expenses: BigDecimal
)
