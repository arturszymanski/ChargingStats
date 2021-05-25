package com.devpanther.data.database.mappers

import com.devpanther.data.database.model.table.ChargeProviderTable
import com.devpanther.domaindata.database.dto.ChargeProviderDTO

fun ChargeProviderDTO.toEntity() =
    ChargeProviderTable(
        id = id,
        providerName = providerName
    )

fun ChargeProviderTable.toDTO() =
    ChargeProviderDTO(
        id = id,
        providerName = providerName
    )