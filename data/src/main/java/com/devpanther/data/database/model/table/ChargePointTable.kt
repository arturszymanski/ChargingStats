package com.devpanther.data.database.model.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "charge_point_table")
data class ChargePointTable(
    @PrimaryKey(autoGenerate = false) val id: UUID,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "charge_provider_id") val chargeProviderId: UUID,
    @ColumnInfo(name = "address_id") val addressId: UUID
)
