package com.nick.nickJetPackProjectAndExtras.room_database.ships

import androidx.room.Embedded
import androidx.room.Relation
import com.nick.sampleroomandretrofit.database.models.ShipsModel

/**
 * One to One relationship
 * parentColumn = "position_id" ---->>>>>> is in the ship model and is the position model id to connect the position model with ship model
 * entityColumn = "positionId" ---->>>>>> is id of position model
 * */
data class ShipAndPositionModel(
        @Embedded
        var positionModel: PositionModel,
        @Relation(
                parentColumn = "position_id",
                entityColumn = "positionId"
        )
        var shipsModel: ShipsModel
) {
}