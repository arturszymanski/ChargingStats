package com.devpanther.domain.mappers

import com.devpanther.domain.model.ChargePointModel
import com.devpanther.domaindata.database.dto.ChargePointDTO

fun ChargePointDTO.toEntity() =
    ChargePointModel(
        id = id,
        name = name,
        address = address.toEntity(),
        chargeProvider = chargeProvider.toEntity()
    )

fun ChargePointModel.toDTO() =
    ChargePointDTO(
        id = id,
        name = name,
        address = address.toDTO(),
        chargeProvider = chargeProvider.toDTO()
    )