package com.devpanther.data.database.model.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "charge_provider_table")
data class ChargeProviderTable(
    @PrimaryKey(autoGenerate = false) val id: UUID,
    @ColumnInfo(name = "provider_name") val providerName: String
)
