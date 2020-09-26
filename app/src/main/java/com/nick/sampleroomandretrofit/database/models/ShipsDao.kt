package com.nick.nickJetPackProjectAndExtras.room_database.ships

import androidx.room.Dao
import androidx.room.Query
import com.nick.sampleroomandretrofit.database.init_database.BaseDao
import com.nick.sampleroomandretrofit.database.models.ShipsModel

@Dao
interface ShipsDao : BaseDao<ShipsModel, MutableList<ShipsModel>> {

    @Query("SELECT * FROM shipsmodel")
    suspend fun getAllShips(): MutableList<ShipsModel>

    @Query("DELETE FROM shipsmodel")
    suspend fun deleteAll()
}