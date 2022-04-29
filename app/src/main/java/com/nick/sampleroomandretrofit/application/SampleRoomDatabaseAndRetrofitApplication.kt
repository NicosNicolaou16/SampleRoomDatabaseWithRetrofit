package com.nick.sampleroomandretrofit.application

import android.app.Application
import com.nick.sampleroomandretrofit.database.init_database.MyRoomDatabase

class SampleRoomDatabaseAndRetrofitApplication: Application() {

    companion object {
        private lateinit var instance: SampleRoomDatabaseAndRetrofitApplication

        @JvmStatic
        fun getInstance() = instance
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    /**
     * Room database instance
     * */
    fun getDatabase(): MyRoomDatabase = MyRoomDatabase(this)
}