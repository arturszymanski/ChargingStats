package com.devpanther.data.database.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.devpanther.data.database.model.table.AddressTable
import com.devpanther.data.database.model.table.ChargePointTable
import com.devpanther.data.database.model.table.ChargeProviderTable

data class ChargePointDB(
    @Embedded val chargePointTable: ChargePointTable,
    @Relation(
        parentColumn = "charge_provider_id",
        entityColumn = "id"
    )
    val chargeProvider: ChargeProviderTable,
    @Relation(
        parentColumn = "address_id",
        entityColumn = "id",
        entity = AddressTable::class
    )
    val address: AddressDB
)