package com.devpanther.data.database.model.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "measure_info_table")
data class MeasureInfoTable(
    @PrimaryKey(autoGenerate = false) val id: UUID,
    @ColumnInfo(name = "mileage") val mileage: Long,
    @ColumnInfo(name = "average_speed") val averageSpeed: Int,
    @ColumnInfo(name = "average_energy_consumption") val averageEnergyConsumption: Double
)