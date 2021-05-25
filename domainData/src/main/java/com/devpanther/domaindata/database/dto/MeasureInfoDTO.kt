package com.devpanther.domaindata.database.dto

import java.util.*

data class MeasureInfoDTO(
    val id: UUID,
    val mileage: Long,
    val averageSpeed: Int,
    val averageEnergyConsumption: Double
)
