package com.devpanther.data.database.mappers

import com.devpanther.data.database.model.relations.ChargePointDB
import com.devpanther.data.database.model.table.ChargePointTable
import com.devpanther.domaindata.database.dto.ChargePointDTO

fun ChargePointDTO.toEntity() =
    ChargePointTable(
        id = id,
        name = name,
        addressId = address.id,
        chargeProviderId = chargeProvider.id
    )

fun ChargePointDB.toDTO() =
    ChargePointDTO(
        id = chargePointTable.id,
        name = chargePointTable.name,
        address = address.toDTO(),
        chargeProvider = chargeProvider.toDTO()
    )