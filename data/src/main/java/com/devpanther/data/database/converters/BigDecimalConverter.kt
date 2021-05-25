package com.devpanther.data.database.converters

import androidx.room.TypeConverter
import java.math.BigDecimal

class BigDecimalConverter {
    @TypeConverter
    fun StringToBigDecimal(string: String) =
        BigDecimal(string)

    @TypeConverter
    fun BigDecimalToString(bigDecimal: BigDecimal) =
        bigDecimal.toPlainString()
}