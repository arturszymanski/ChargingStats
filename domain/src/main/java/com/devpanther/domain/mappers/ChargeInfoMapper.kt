package com.devpanther.domain.mappers

import com.devpanther.domain.model.ChargeInfoModel
import com.devpanther.domaindata.database.dto.ChargeInfoDTO

fun ChargeInfoDTO.toEntity() =
    ChargeInfoModel(
        id = id,
        chargeDurationMillis = chargeDurationMillis,
        chargeBillable = chargeBillable,
        chargeDate = chargeDate,
        chargeExpenses = chargeExpenses,
        chargedPowerAmount = chargedPowerAmount,
        chargePower = chargePower,
        chargePoint = chargePoint.toEntity(),
        measureInfo = measureInfo?.toEntity()
    )

fun ChargeInfoModel.toDTO() =
    ChargeInfoDTO(
        id = id,
        chargeDurationMillis = chargeDurationMillis,
        chargeBillable = chargeBillable,
        chargeDate = chargeDate,
        chargeExpenses = chargeExpenses,
        chargedPowerAmount = chargedPowerAmount,
        chargePower = chargePower,
        chargePoint = chargePoint.toDTO(),
        measureInfo = measureInfo?.toDTO(),
        additionalExpenses = additionalExpenses.map { it.toDTO() }
    )