package com.devpanther.domain.mappers

import com.devpanther.domain.model.MeasureInfoModel
import com.devpanther.domaindata.database.dto.MeasureInfoDTO

fun MeasureInfoDTO.toEntity() =
    MeasureInfoModel(
        id = id,
        mileage = mileage,
        averageSpeed = averageSpeed,
        averageEnergyConsumption = averageEnergyConsumption
    )

fun MeasureInfoModel.toDTO() =
    MeasureInfoDTO(
        id = id,
        mileage = mileage,
        averageSpeed = averageSpeed,
        averageEnergyConsumption = averageEnergyConsumption
    )