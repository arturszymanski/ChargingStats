package com.devpanther.domaindata.database

import com.devpanther.domaindata.database.dto.ChargeInfoDTO
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface DataBaseData {
    fun getAll(): Single<List<ChargeInfoDTO>>

    fun addAll(vararg chargeInfoDTO: ChargeInfoDTO): Completable
}