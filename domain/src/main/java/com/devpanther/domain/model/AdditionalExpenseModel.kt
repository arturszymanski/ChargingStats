package com.devpanther.domain.model

import java.math.BigDecimal
import java.util.*

data class AdditionalExpenseModel(
    val id: UUID,
    val type: AdditionalExpensesTypeModel,
    val expenses: BigDecimal
)
