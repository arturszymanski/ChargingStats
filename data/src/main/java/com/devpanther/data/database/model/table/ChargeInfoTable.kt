package com.devpanther.data.database.model.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.util.*

@Entity(tableName = "charge_info_table")
data class ChargeInfoTable(
    @PrimaryKey(autoGenerate = false) val id: UUID,
    @ColumnInfo(name = "charge_duration_millis") val chargeDurationMillis: Long,
    @ColumnInfo(name = "charge_point_id") val chargePointId: UUID,
    @ColumnInfo(name = "charge_billable") val chargeBillable: Boolean,
    @ColumnInfo(name = "charge_expenses") val chargeExpenses: BigDecimal,
    @ColumnInfo(name = "charge_power") val chargePower: Double,
    @ColumnInfo(name = "charge_date_millis") val chargeDate: String,
    @ColumnInfo(name = "charged_power_amount") val chargedPowerAmount: Double,
    @ColumnInfo(name = "measure_info_id") val measureInfoId: UUID?,
)