package com.nick.sampleroomandretrofit.modules.ships.ship_service

import com.nick.sampleroomandretrofit.database.models.ShipsModel
import retrofit2.http.GET

interface ShipService {

    @GET("")
    suspend fun getShips(): MutableList<ShipsModel>
}