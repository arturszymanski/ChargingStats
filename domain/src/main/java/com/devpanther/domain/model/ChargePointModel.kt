package com.devpanther.domain.model

import java.util.*

data class ChargePointModel(
    val id: UUID,
    val name: String,
    val chargeProvider: ChargeProviderModel,
    val address: AddressModel
)
