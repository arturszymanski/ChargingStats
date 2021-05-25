package com.devpanther.domain.usecase

import com.devpanther.domain.datasource.ChargeInfoDataSource
import com.devpanther.domain.model.ChargeInfoModel
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class StoreChargeInfoUseCase @Inject constructor(
    private val chargeInfoDataSource: ChargeInfoDataSource
) {
    fun execute(vararg chargeInfoModel: ChargeInfoModel): Completable =
        chargeInfoDataSource
            .storeChargeInfo(*chargeInfoModel)
            .runAsyncReturnOnMain()
}