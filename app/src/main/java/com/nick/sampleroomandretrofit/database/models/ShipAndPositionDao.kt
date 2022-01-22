package com.nick.sampleroomandretrofit.database.models

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.nick.nickJetPackProjectAndExtras.room_database.ships.ShipAndPositionModel

@Dao
interface ShipAndPositionDao {

    @Transaction
    @Query("SELECT * FROM PositionModel")
    fun getShipAndPosition(): MutableList<ShipAndPositionModel>
}