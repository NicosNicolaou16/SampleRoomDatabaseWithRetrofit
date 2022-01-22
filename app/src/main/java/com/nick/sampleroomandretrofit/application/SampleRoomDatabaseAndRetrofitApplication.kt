package com.nick.sampleroomandretrofit.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SampleRoomDatabaseAndRetrofitApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}