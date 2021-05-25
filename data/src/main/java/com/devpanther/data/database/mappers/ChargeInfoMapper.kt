package com.devpanther.data.database.mappers

import com.devpanther.data.database.model.relations.ChargeInfoDB
import com.devpanther.data.database.model.table.ChargeInfoTable
import com.devpanther.domaindata.database.dto.ChargeInfoDTO

fun ChargeInfoDTO.toEntity() =
    ChargeInfoTable(
        id = id,
        chargeDurationMillis = chargeDurationMillis,
        chargeBillable = chargeBillable,
        chargeDate = chargeDate,
        chargeExpenses = chargeExpenses,
        chargedPowerAmount = chargedPowerAmount,
        chargePower = chargePower,
        chargePointId = chargePoint.id,
        measureInfoId = measureInfo?.id
    )

fun ChargeInfoDB.toDTO() =
    ChargeInfoDTO(
        id = chargeInfo.id,
        chargeDurationMillis = chargeInfo.chargeDurationMillis,
        chargeBillable = chargeInfo.chargeBillable,
        chargeDate = chargeInfo.chargeDate,
        chargeExpenses = chargeInfo.chargeExpenses,
        chargedPowerAmount = chargeInfo.chargedPowerAmount,
        chargePower = chargeInfo.chargePower,
        chargePoint = chargePoint.toDTO(),
        measureInfo = measureInfo?.toDTO(),
        additionalExpenses = additionalExpenses.map { it.toDTO() }
    )