package com.devpanther.domaindata.database.dto

import java.util.*

data class LocationDTO(
    val id: UUID,
    val lat: Double,
    val lng: Double
)