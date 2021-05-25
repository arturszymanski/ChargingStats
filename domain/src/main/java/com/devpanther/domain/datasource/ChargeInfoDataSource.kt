package com.devpanther.domain.datasource

import com.devpanther.domain.model.ChargeInfoModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface ChargeInfoDataSource {
    fun storeChargeInfo(vararg chargeInfoModels: ChargeInfoModel): Completable

    fun restoreChargeInfo(): Single<List<ChargeInfoModel>>
}