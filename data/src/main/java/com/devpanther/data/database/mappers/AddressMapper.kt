package com.devpanther.data.database.mappers

import com.devpanther.data.database.model.relations.AddressDB
import com.devpanther.data.database.model.table.AddressTable
import com.devpanther.domaindata.database.dto.AddressDTO

fun AddressDTO.toEntity() =
    AddressTable(
        id = id,
        locationId = location.id
    )

fun AddressDB.toDTO() =
    AddressDTO(
        id = address.id,
        location = location.toDTO()
    )