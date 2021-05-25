package com.devpanther.domain.mappers

import com.devpanther.domain.model.ChargeProviderModel
import com.devpanther.domaindata.database.dto.ChargeProviderDTO

fun ChargeProviderDTO.toEntity() =
    ChargeProviderModel(
        id = id,
        providerName = providerName
    )

fun ChargeProviderModel.toDTO() =
    ChargeProviderDTO(
        id = id,
        providerName = providerName
    )