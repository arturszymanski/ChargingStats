package com.devpanther.domain.usecase

import com.devpanther.domain.datasource.ChargeInfoDataSource
import com.devpanther.domain.model.ChargeInfoModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RestoreChargeInfoUseCase @Inject constructor(
    private val chargeInfoDataSource: ChargeInfoDataSource
) {
    fun execute(): Single<List<ChargeInfoModel>> =
        chargeInfoDataSource
            .restoreChargeInfo()
            .runAsyncReturnOnMain()
}