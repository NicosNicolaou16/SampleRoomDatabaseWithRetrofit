package com.nick.sampleroomandretrofit.database.init_database

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object MyRoomDatabaseModule {

    /**
     * Reference for Hilt: https://github.com/google/iosched
     * */
    @Provides
    fun initRoomDataBase(@ApplicationContext context: Context): MyRoomDatabase {
        return MyRoomDatabase.buildDatabase(context)
    }
}