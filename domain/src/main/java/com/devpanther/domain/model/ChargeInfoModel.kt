package com.devpanther.domain.model

import java.math.BigDecimal
import java.util.*

data class ChargeInfoModel(
    val id: UUID,
    val chargeDurationMillis: Long,
    val chargePoint: ChargePointModel,
    val chargeBillable: Boolean,
    val chargeExpenses: BigDecimal,
    val chargePower: Double,
    val chargeDate: String,
    val chargedPowerAmount: Double,
    val measureInfo: MeasureInfoModel?,
    val additionalExpenses: List<AdditionalExpenseModel> = emptyList()
)
