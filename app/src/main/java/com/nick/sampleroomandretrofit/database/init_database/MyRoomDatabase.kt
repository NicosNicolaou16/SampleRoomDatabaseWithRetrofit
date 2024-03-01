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
import javax.inject.Inject

@Database(
        entities = [ShipsModel::class, PositionModel::class],
        version = 1,
        exportSchema = false
)
@TypeConverters(ConverterPosition::class, )
abstract class MyRoomDatabase : RoomDatabase() {

    @Inject
    internal lateinit var myRoomDatabase: MyRoomDatabase

    abstract fun shipDao(): ShipsDao
    abstract fun positionDao(): PositionDao
    abstract fun shipAndPositionDao(): ShipAndPositionDao

    companion object {
        private const val DB_NAME = "DB_NAME"

        private val LOCK = Any()

        /**
         * Reference for Hilt: https://github.com/google/iosched
         * */
        internal fun buildDatabase(context: Context) = synchronized(LOCK) {
            Room.databaseBuilder(
                context.applicationContext,
                MyRoomDatabase::class.java,
                DB_NAME
            ).build()
        }
    }
}