package com.devpanther.data.database.mappers

import com.devpanther.data.database.model.table.MeasureInfoTable
import com.devpanther.domaindata.database.dto.MeasureInfoDTO

fun MeasureInfoDTO.toEntity() =
    MeasureInfoTable(
        id = id,
        mileage = mileage,
        averageSpeed = averageSpeed,
        averageEnergyConsumption = averageEnergyConsumption
    )

fun MeasureInfoTable.toDTO() =
    MeasureInfoDTO(
        id = id,
        mileage = mileage,
        averageSpeed = averageSpeed,
        averageEnergyConsumption = averageEnergyConsumption
    )