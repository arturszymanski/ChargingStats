package com.devpanther.domain.model

import java.util.*

data class MeasureInfoModel(
    val id: UUID,
    val mileage: Long,
    val averageSpeed: Int,
    val averageEnergyConsumption: Double
)
