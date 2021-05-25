package com.devpanther.domain.mappers

import com.devpanther.domain.model.LocationModel
import com.devpanther.domaindata.database.dto.LocationDTO

fun LocationDTO.toEntity() =
    LocationModel(
        id = id,
        lat = lat,
        lng = lng
    )

fun LocationModel.toDTO() =
    LocationDTO(
        id = id,
        lat = lat,
        lng = lng
    )