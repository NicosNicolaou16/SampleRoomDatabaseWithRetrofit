package com.nick.sampleroomandretrofit.database.models

import androidx.room.Dao
import androidx.room.Query
import com.nick.sampleroomandretrofit.database.init_database.BaseDao
import com.nick.sampleroomandretrofit.database.models.ShipsModel

@Dao
interface ShipsDao : BaseDao<ShipsModel, MutableList<ShipsModel>> {

    @Query("SELECT * FROM shipsmodel")
    suspend fun getAllShips(): MutableList<ShipsModel>

    @Query("SELECT * FROM shipsmodel WHERE ship_id =:shipId")
    suspend fun getShipById(shipId: String): ShipsModel

    @Query("DELETE FROM shipsmodel")
    suspend fun deleteAll()
}