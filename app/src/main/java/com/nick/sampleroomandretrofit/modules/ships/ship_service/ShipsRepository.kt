package com.nick.sampleroomandretrofit.modules.ships.ship_service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ShipsRepository {
    companion object {
        const val BASE_URL = "https://api.spacexdata.com"
    }

    fun requestBuilder() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShipService::class.java)
}