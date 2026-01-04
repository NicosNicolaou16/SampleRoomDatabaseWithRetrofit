package com.nick.sampleroomandretrofit.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nick.sampleroomandretrofit.application.SampleRoomDatabaseAndRetrofitApplication
import kotlinx.coroutines.flow.flow

@Entity
data class PositionModel(
    @PrimaryKey(autoGenerate = true)
    var position_id: Long,
    var latitude: Double?,
    var longitude: Double?
) {

    companion object {
        suspend fun insertThePosition(positionModel: PositionModel) =
            with(SampleRoomDatabaseAndRetrofitApplication.getInstance()) {
                flow {
                    getDatabase().positionDao().insertOrReplaceObject(positionModel)
                    emit(getDatabase().positionDao().getPosition())
                }
            }
    }
}