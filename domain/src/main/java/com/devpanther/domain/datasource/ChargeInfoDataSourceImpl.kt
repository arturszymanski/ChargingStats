package com.devpanther.domain.datasource

import com.devpanther.domain.mappers.toDTO
import com.devpanther.domain.mappers.toEntity
import com.devpanther.domain.model.ChargeInfoModel
import com.devpanther.domaindata.database.DataBaseData
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ChargeInfoDataSourceImpl @Inject constructor(
    private val dataBaseData: DataBaseData
) : ChargeInfoDataSource {

    override fun storeChargeInfo(vararg chargeInfoModels: ChargeInfoModel): Completable {
        val mappedModels =
            chargeInfoModels
                .map { it.toDTO() }

        return dataBaseData
            .addAll(*mappedModels.toTypedArray())
    }

    override fun restoreChargeInfo(): Single<List<ChargeInfoModel>> =
        dataBaseData
            .getAll()
            .toFlowable()
            .flatMapIterable { it }
            .map { it.toEntity() }
            .toList()
}