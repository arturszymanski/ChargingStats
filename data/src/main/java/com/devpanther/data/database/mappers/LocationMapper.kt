package com.devpanther.data.database.mappers

import com.devpanther.data.database.model.table.LocationTable
import com.devpanther.domaindata.database.dto.LocationDTO

fun LocationDTO.toEntity() =
    LocationTable(
        id = id,
        lat = lat,
        lng = lng
    )

fun LocationTable.toDTO() =
    LocationDTO(
        id = id,
        lat = lat,
        lng = lng
    )