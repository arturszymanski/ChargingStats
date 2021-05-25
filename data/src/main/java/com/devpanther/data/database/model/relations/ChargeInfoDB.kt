package com.devpanther.data.database.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.devpanther.data.database.model.table.AdditionalExpenseTable
import com.devpanther.data.database.model.table.ChargeInfoTable
import com.devpanther.data.database.model.table.ChargePointTable
import com.devpanther.data.database.model.table.MeasureInfoTable

data class ChargeInfoDB(
    @Embedded val chargeInfo: ChargeInfoTable,
    @Relation(
        parentColumn = "charge_point_id",
        entityColumn = "id",
        entity = ChargePointTable::class
    )
    val chargePoint: ChargePointDB,
    @Relation(
        parentColumn = "measure_info_id",
        entityColumn = "id"
    )
    val measureInfo: MeasureInfoTable?,
    @Relation(
        parentColumn = "id",
        entityColumn = "charge_info_id",
        entity = AdditionalExpenseTable::class
    )
    val additionalExpenses: List<AdditionalExpenseDB> = emptyList()
)