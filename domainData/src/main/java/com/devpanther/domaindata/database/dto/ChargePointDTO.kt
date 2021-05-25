package com.devpanther.domaindata.database.dto

import java.util.*

data class ChargePointDTO(
    val id: UUID,
    val name: String,
    val chargeProvider: ChargeProviderDTO,
    val address: AddressDTO
)
