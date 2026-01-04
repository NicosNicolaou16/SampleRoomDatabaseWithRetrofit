package com.nick.sampleroomandretrofit.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nick.sampleroomandretrofit.database.init_database.MyRoomDatabase
import kotlinx.coroutines.flow.flow

@Entity
data class PositionModel(
    @PrimaryKey(autoGenerate = true)
    var position_id: Long,
    var latitude: Double?,
    var longitude: Double?
) {

    companion object {
        suspend fun insertThePosition(
            positionModel: PositionModel,
            myRoomDatabase: MyRoomDatabase
        ) = flow {
            myRoomDatabase.positionDao().insertOrReplaceObject(positionModel)
            emit(myRoomDatabase.positionDao().getPosition())
        }
    }
}