package com.nick.sampleroomandretrofit.database.init_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nick.nickJetPackProjectAndExtras.room_database.ships.PositionDao
import com.nick.nickJetPackProjectAndExtras.room_database.ships.PositionModel
import com.nick.nickJetPackProjectAndExtras.room_database.ships.ShipAndPositionDao
import com.nick.nickJetPackProjectAndExtras.room_database.ships.ShipsDao
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
    protected lateinit var myRoomDatabase: MyRoomDatabase

    abstract fun shipDao(): ShipsDao
    abstract fun positionDao(): PositionDao
    abstract fun shipAndPositionDao(): ShipAndPositionDao

    fun deleteAll() {
        this.clearAllTables()
    }

    companion object {
        internal const val DB_NAME = "DB_NAME"
    }
}