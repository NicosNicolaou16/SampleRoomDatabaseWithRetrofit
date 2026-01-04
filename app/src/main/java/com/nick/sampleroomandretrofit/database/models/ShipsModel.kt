package com.nick.sampleroomandretrofit.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nick.sampleroomandretrofit.application.SampleRoomDatabaseAndRetrofitApplication
import com.nick.sampleroomandretrofit.database.type_converters.ConverterPosition
import kotlinx.coroutines.flow.flow

@Entity
data class ShipsModel(
    @PrimaryKey
    var ship_id: String,
    var ship_name: String?,
    var ship_type: String?,
    @TypeConverters(ConverterPosition::class)
    var position: PositionModel,
    var positionId: Long,
    var successful_landings: Int?,
    var attempted_landings: Int?,
    var url: String?,
    var image: String?
) {

    companion object {

        fun insertShips(shipsModelList: MutableList<ShipsModel>) =
            with(SampleRoomDatabaseAndRetrofitApplication.getInstance()) {
                flow {
                    deletePositionModel()
                    val shipsModelListTemp = mutableListOf<ShipsModel>()
                    shipsModelList.forEach {
                        insertPosition(it)
                        shipsModelListTemp.add(it)
                    }
                    getDatabase().shipDao().insertOrReplaceList(shipsModelListTemp)
                    emit(getDatabase().shipDao().getAllShips())
                }
            }

        private suspend fun insertPosition(shipsModel: ShipsModel) {
            PositionModel.insertThePosition(shipsModel.position).collect {
                shipsModel.positionId = it.position_id
            }
        }

        private suspend fun deletePositionModel() =
            with(SampleRoomDatabaseAndRetrofitApplication.getInstance()) {
                getDatabase().positionDao().deleteAll()
            }
    }
}