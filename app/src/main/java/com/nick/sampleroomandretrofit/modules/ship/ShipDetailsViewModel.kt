package com.nick.sampleroomandretrofit.modules.ship

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.application.SampleRoomDatabaseAndRetrofitApplication
import com.nick.sampleroomandretrofit.database.models.ShipsModel
import com.nick.sampleroomandretrofit.utils.base_classes.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShipDetailsViewModel(application: Application) : BaseViewModel(application) {

    var shipDetails = MutableLiveData<ShipsModel>()

    fun getSpecificShipById(shipId: String) = with(SampleRoomDatabaseAndRetrofitApplication.getInstance()) {
        if (shipId != "") {
            launch {
                loading.value = true
                var shipsModel: ShipsModel
                withContext(Dispatchers.IO) {
                    shipsModel = getDatabase().shipDao().getShipById(shipId)
                }
                loading.value = false
                shipDetails.value = shipsModel
            }
        } else {
            loading.value = false
            error.value = getString(R.string.something_went_wrong)
        }
    }
}