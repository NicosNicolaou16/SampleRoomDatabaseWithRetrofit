package com.nick.nickJetPackProjectAndExtras.room_database.ships

import androidx.room.Embedded
import androidx.room.Relation
import com.nick.sampleroomandretrofit.database.models.ShipsModel

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