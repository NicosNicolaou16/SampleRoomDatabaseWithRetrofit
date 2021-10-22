package com.nick.sampleroomandretrofit.modules.ships.ship_service

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object ShipsModules {
    private const val BASE_URL = "https://api.spacexdata.com"


    @Provides
    fun getShipsList(retrofit: Retrofit): ShipService {
        return retrofit.create(ShipService::class.java)
    }

    @Provides
    fun requestBuilder(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}