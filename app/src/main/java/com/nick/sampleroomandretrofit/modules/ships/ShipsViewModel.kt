package com.nick.sampleroomandretrofit.modules.ships

import android.app.Application
import androidx.lifecycle.asLiveData
import com.nick.sampleroomandretrofit.database.models.ShipsModel
import com.nick.sampleroomandretrofit.modules.ships.ship_service.ShipService
import com.nick.sampleroomandretrofit.utils.base_classes.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ShipsViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    @Inject
    protected lateinit var shipService: ShipService
    var ships = requestShips().asLiveData()

    private fun requestShips() =
        flow {
            loading.value = true
            var shipsModelList: MutableList<ShipsModel>
            withContext(Dispatchers.IO) {
                shipsModelList = shipService.getShips()
                ShipsModel.insertShips(shipsModelList, myRoomDatabase).collect {
                    shipsModelList = it
                }
            }
            loading.value = false
            emit(shipsModelList)
        }.catch {
            loading.value = false
            error.value = handleErrorMessage(it)
        }
}