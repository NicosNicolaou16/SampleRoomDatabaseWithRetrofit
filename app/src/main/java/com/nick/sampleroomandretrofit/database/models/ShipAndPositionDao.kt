package com.nick.nickJetPackProjectAndExtras.room_database.ships

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface ShipAndPositionDao {

    @Transaction
    @Query("SELECT * FROM PositionModel")
    fun getShipAndPosition(): MutableList<ShipAndPositionModel>
}