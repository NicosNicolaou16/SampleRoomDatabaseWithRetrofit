package com.nick.nickJetPackProjectAndExtras.room_database.ships

import androidx.room.Dao
import androidx.room.Query
import com.nick.sampleroomandretrofit.database.init_database.BaseDao

@Dao
interface PositionDao: BaseDao<PositionModel, MutableList<PositionModel>> {

    @Query("SELECT * FROM positionmodel")
    suspend fun getPosition(): PositionModel

    @Query("SELECT * FROM positionmodel WHERE latitude =:latitude")
    suspend fun getSpecificPosition(latitude: Double): PositionModel?

    @Query("DELETE FROM PositionModel")
    suspend fun deleteAll()
}