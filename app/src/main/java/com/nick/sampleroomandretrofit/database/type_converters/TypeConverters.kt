package com.nick.sampleroomandretrofit.database.type_converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nick.sampleroomandretrofit.database.models.PositionModel

class ConverterPosition {

    @TypeConverter
    fun fromStringToPositions(value: String): PositionModel? {
        return Gson().fromJson(value, object : TypeToken<PositionModel>() {}.type)
    }

    @TypeConverter
    fun fromPositionToString(positionModel: PositionModel): String = Gson().toJson(positionModel)
}