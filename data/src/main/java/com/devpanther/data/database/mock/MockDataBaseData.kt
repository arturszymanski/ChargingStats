package com.devpanther.data.database.mock

import com.devpanther.data.BuildConfig
import com.devpanther.domaindata.database.dto.*
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.UUID
import kotlin.random.Random

class MockDataBaseData {
    private val chargePoints: List<ChargePointDTO> = listOf(
        ChargePointDTO(
            id = UUID.randomUUID(),
            name = "MOP Szumowo",
            address = AddressDTO(
                id = UUID.randomUUID(),
                location = LocationDTO(
                    id = UUID.randomUUID(),
                    lat = 52.9084128,
                    lng = 22.0926431
                )
            ),
            chargeProvider = ChargeProviderDTO(
                id = UUID.randomUUID(),
                providerName = "Orlen"
            )
        ),
        ChargePointDTO(
            id = UUID.randomUUID(),
            name = "Złote Tarasy",
            address = AddressDTO(
                id = UUID.randomUUID(),
                location = LocationDTO(
                    id = UUID.randomUUID(),
                    lat = 52.2302364,
                    lng = 21.0023899
                )
            ),
            chargeProvider = ChargeProviderDTO(
                id = UUID.randomUUID(),
                providerName = "Złote Tarasy"
            )
        ),
        ChargePointDTO(
            id = UUID.randomUUID(),
            name = "Warszawa Wschodnia",
            address = AddressDTO(
                id = UUID.randomUUID(),
                location = LocationDTO(
                    id = UUID.randomUUID(),
                    lat = 52.9084128,
                    lng = 22.0926431
                )
            ),
            chargeProvider = ChargeProviderDTO(
                id = UUID.randomUUID(),
                providerName = "Miasto Warszawa"
            )
        )
    )

    private val additionalExpenseType = AdditionalExpenseTypeDTO(
        id = UUID.randomUUID(),
        name = "Parking"
    )
    private val additionalExpense = AdditionalExpenseDTO(
        id = UUID.randomUUID(),
        expenses = BigDecimal(
            "${Random.nextInt(5, 20)}.${Random.nextInt(0, 100)}"
        ),
        type = additionalExpenseType
    )

    fun getChargeInfos(): List<ChargeInfoDTO> =
        (0..Random.nextInt(1, 6))
            .map {
                generateChargeInfo()
            }

    private fun generateChargeInfo(): ChargeInfoDTO {
        val additionalExpenses = mutableListOf<AdditionalExpenseDTO>()
        val chargeBillable = Random.nextBoolean()
        if (chargeBillable) {
            additionalExpenses.add(additionalExpense)
        }

        return ChargeInfoDTO(
            id = UUID.randomUUID(),
            chargeDurationMillis = Random.nextLong(1800000L, 72000000L),
            chargeBillable = chargeBillable,
            chargeDate = SimpleDateFormat(BuildConfig.DB_DATE_FORMAT).format(
                System.currentTimeMillis() - Random.nextLong()
            ),
            chargeExpenses = BigDecimal(
                "${Random.nextInt(5, 150)}.${Random.nextInt(0, 100)}"
            ),
            chargedPowerAmount = Random.nextDouble(10.0, 90.0),
            chargePower = Random.nextDouble(3.0, 150.0),
            chargePoint = chargePoints[Random.nextInt(0, 3)],
            measureInfo = MeasureInfoDTO(
                id = UUID.randomUUID(),
                mileage = Random.nextLong(1000, 15000),
                averageSpeed = Random.nextInt(10, 140),
                averageEnergyConsumption = Random.nextDouble(15.0, 25.0)
            ),
            additionalExpenses = additionalExpenses
        )
    }
}