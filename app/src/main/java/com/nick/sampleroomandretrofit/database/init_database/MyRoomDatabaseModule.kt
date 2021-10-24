package com.nick.sampleroomandretrofit.database.init_database

import android.content.Context
import androidx.room.Room
import com.nick.sampleroomandretrofit.database.init_database.MyRoomDatabase.Companion.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object MyRoomDatabaseModule {

    private val LOCK = Any()

    @Provides
    fun initRoomDataBase(@ApplicationContext context: Context): MyRoomDatabase {
        return synchronized(LOCK) { Room.databaseBuilder(
            context.applicationContext,
            MyRoomDatabase::class.java,
            DB_NAME
        ).build() }
    }
}