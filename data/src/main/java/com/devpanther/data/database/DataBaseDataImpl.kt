package com.devpanther.data.database

import com.devpanther.data.database.dao.*
import com.devpanther.data.database.mappers.toDTO
import com.devpanther.data.database.mappers.toEntity
import com.devpanther.data.database.model.table.*
import com.devpanther.domaindata.database.DataBaseData
import com.devpanther.domaindata.database.dto.ChargeInfoDTO
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DataBaseDataImpl @Inject constructor(
    private val additionalExpenseDao: AdditionalExpenseDao,
    private val additionalExpenseTypeDao: AdditionalExpenseTypeDao,
    private val addressDao: AddressDao,
    private val chargeInfoDao: ChargeInfoDao,
    private val chargePointDao: ChargePointDao,
    private val chargeProviderDao: ChargeProviderDao,
    private val locationDao: LocationDao,
    private val measureInfoDao: MeasureInfoDao
) : DataBaseData {
    override fun getAll(): Single<List<ChargeInfoDTO>> =
        Single.create {
            try {
                val chargeInfoList = chargeInfoDao
                    .getAllDB()
                    .map { chargeInfoDB -> chargeInfoDB.toDTO() }
                it.onSuccess(chargeInfoList)
            } catch (throwable: Throwable) {
                it.tryOnError(throwable)
            }
        }

    override fun addAll(vararg chargeInfoDTO: ChargeInfoDTO): Completable =
        Completable.create {
            try {
                val chargeInfoTables = mutableSetOf<ChargeInfoTable>()
                val chargePointTables = mutableSetOf<ChargePointTable>()
                val chargeProviderTables = mutableSetOf<ChargeProviderTable>()
                val addressTables = mutableSetOf<AddressTable>()
                val additionalExpensesTypeTables = mutableSetOf<AdditionalExpensesTypeTable>()
                val additionalExpenseTables = mutableSetOf<AdditionalExpenseTable>()
                val measureInfoTables = mutableSetOf<MeasureInfoTable>()
                val locationTables = mutableSetOf<LocationTable>()

                chargeInfoDTO
                    .forEach { chargeInfoDTO ->
                        chargeInfoTables.add(chargeInfoDTO.toEntity())

                        chargePointTables
                            .add(chargeInfoDTO.chargePoint.toEntity())
                        addressTables
                            .add(chargeInfoDTO.chargePoint.address.toEntity())
                        locationTables
                            .add(chargeInfoDTO.chargePoint.address.location.toEntity())
                        chargeProviderTables
                            .add(chargeInfoDTO.chargePoint.chargeProvider.toEntity())

                        chargeInfoDTO.additionalExpenses.forEach { additionalExpenseDTO ->
                            additionalExpenseTables
                                .add(additionalExpenseDTO.toEntity(chargeInfoId = chargeInfoDTO.id))
                            additionalExpensesTypeTables
                                .add(additionalExpenseDTO.type.toEntity())
                        }

                        chargeInfoDTO.measureInfo?.toEntity()?.let { measureInfo ->
                            measureInfoTables.add(measureInfo)
                        }
                    }

                chargeInfoDao
                    .insertAll(*chargeInfoTables.toTypedArray())
                chargePointDao
                    .insertAll(*chargePointTables.toTypedArray())
                chargeProviderDao
                    .insertAll(*chargeProviderTables.toTypedArray())
                addressDao
                    .insertAll(*addressTables.toTypedArray())
                additionalExpenseTypeDao
                    .insertAll(*additionalExpensesTypeTables.toTypedArray())
                additionalExpenseDao
                    .insertAll(*additionalExpenseTables.toTypedArray())
                measureInfoDao
                    .insertAll(*measureInfoTables.toTypedArray())
                locationDao
                    .insertAll(*locationTables.toTypedArray())

                it.onComplete()
            } catch (throwable: Throwable) {
                it.tryOnError(throwable)
            }
        }
}