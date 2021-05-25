package com.devpanther.domain.mappers

import com.devpanther.domain.model.AddressModel
import com.devpanther.domaindata.database.dto.AddressDTO

fun AddressDTO.toEntity() =
    AddressModel(
        id = id,
        location = location.toEntity()
    )

fun AddressModel.toDTO() =
    AddressDTO(
        id = id,
        location = location.toDTO()
    )