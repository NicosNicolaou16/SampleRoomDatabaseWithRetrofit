package com.nick.sampleroomandretrofit.modules.ships.models

import com.nick.sampleroomandretrofit.database.models.ShipsModel

data class ShipsDataModel(
    var shipsModel: ShipsModel,
    var shipsViewTypes: ShipsViewTypes,
) {

    enum class ShipsViewTypes {
        SHIP_VIEW_TYPE,
    }

    companion object {
        fun createShipDataModel(shipsModelList: MutableList<ShipsModel>): MutableList<ShipsDataModel> {
            return mutableListOf<ShipsDataModel>().apply {
                shipsModelList.forEach { ship ->
                    add(
                        ShipsDataModel(
                            shipsModel = ship,
                            shipsViewTypes = ShipsViewTypes.SHIP_VIEW_TYPE
                        )
                    )
                }
            }
        }
    }
}