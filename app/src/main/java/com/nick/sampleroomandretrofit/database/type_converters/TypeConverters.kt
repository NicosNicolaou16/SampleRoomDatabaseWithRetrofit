package com.nick.sampleroomandretrofit.database.type_converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nick.nickJetPackProjectAndExtras.room_database.ships.PositionModel

class ConverterPosition {

    /**
     * EXAMPLE
     * json object with inner json object
     * "key": {
     *      "key1": value,
     *      "key2": value
     *      },
     * */

    /**
     * val listType: Type = object : TypeToken<Any>() {}.type
     * return Gson().fromJson(value, listType)
     * */
    @TypeConverter
    fun fromStringToPositions(value: String): PositionModel? {
        return Gson().fromJson(value, object : TypeToken<PositionModel>() {}.type)
    }

    @TypeConverter
    fun fromPositionToString(positionModel: PositionModel): String = Gson().toJson(positionModel)
}