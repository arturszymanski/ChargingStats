package com.devpanther.domaindata.database.dto

import java.math.BigDecimal
import java.util.*

data class ChargeInfoDTO(
    val id: UUID,
    val chargeDurationMillis: Long,
    val chargePoint: ChargePointDTO,
    val chargeBillable: Boolean,
    val chargeExpenses: BigDecimal,
    val chargePower: Double,
    val chargeDate: String,
    val chargedPowerAmount: Double,
    val measureInfo: MeasureInfoDTO?,
    val additionalExpenses: List<AdditionalExpenseDTO> = emptyList()
)