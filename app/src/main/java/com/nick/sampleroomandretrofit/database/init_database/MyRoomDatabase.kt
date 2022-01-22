package com.nick.sampleroomandretrofit.database.init_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nick.sampleroomandretrofit.database.models.PositionDao
import com.nick.sampleroomandretrofit.database.models.PositionModel
import com.nick.sampleroomandretrofit.database.models.ShipAndPositionDao
import com.nick.sampleroomandretrofit.database.models.ShipsDao
import com.nick.sampleroomandretrofit.database.models.ShipsModel
import com.nick.sampleroomandretrofit.database.type_converters.ConverterPosition

@Database(
        entities = [ShipsModel::class, PositionModel::class],
        version = 1,
        exportSchema = false
)
@TypeConverters(ConverterPosition::class, )
abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun shipDao(): ShipsDao
    abstract fun positionDao(): PositionDao
    abstract fun shipAndPositionDao(): ShipAndPositionDao

    companion object {
        @Volatile
        private var instance: MyRoomDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "DB_NAME"

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
                context.applicationContext,
                MyRoomDatabase::class.java,
                DB_NAME
        ).build()

        fun destroyInstance() {
            instance = null
        }

        fun deleteAll() {
            instance?.clearAllTables()
        }
    }
}