package com.devpanther.data.database.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.devpanther.data.database.model.table.AddressTable
import com.devpanther.data.database.model.table.LocationTable

data class AddressDB(
    @Embedded val address: AddressTable,
    @Relation(
        parentColumn = "location_id",
        entityColumn = "id"
    )
    val location: LocationTable
)
