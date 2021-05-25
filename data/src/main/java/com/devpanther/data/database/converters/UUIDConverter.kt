package com.devpanther.data.database.converters

import androidx.room.TypeConverter
import java.util.*

class UUIDConverter {
    @TypeConverter
    fun StringToUUID(string: String) =
        UUID.fromString(string)

    @TypeConverter
    fun UUIDToString(uuid: UUID) =
        uuid.toString()
}