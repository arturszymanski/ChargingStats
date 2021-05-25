package com.devpanther.data.database.model.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "address_table")
data class AddressTable(
    @PrimaryKey(autoGenerate = false) val id: UUID,
    @ColumnInfo(name = "location_id") val locationId: UUID
)
