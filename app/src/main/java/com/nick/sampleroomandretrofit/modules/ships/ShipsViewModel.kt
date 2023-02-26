package com.nick.sampleroomandretrofit.modules.ships

import android.app.Application
import androidx.lifecycle.asLiveData
import com.nick.sampleroomandretrofit.database.models.ShipsModel
import com.nick.sampleroomandretrofit.modules.ships.models.ShipsDataModel
import com.nick.sampleroomandretrofit.modules.ships.ship_service.ShipsRepository
import com.nick.sampleroomandretrofit.utils.base_classes.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class ShipsViewModel(application: Application) : BaseViewModel(application) {

    private val shipsRepository = ShipsRepository()
    var ships = requestShips().asLiveData()

    private fun requestShips() = flow {
        loading.value = true
        var shipsDataModel = mutableListOf<ShipsDataModel>()
        withContext(Dispatchers.IO) {
            val shipsModelList = shipsRepository.requestBuilder().getShips()
            ShipsModel.insertShips(shipsModelList).collect {
                shipsDataModel = ShipsDataModel.createShipDataModel(it)
            }
        }
        loading.value = false
        emit(shipsDataModel)
    }.catch {
        loading.value = false
        error.value = handleErrorMessage(it)
    }
}