package com.nick.sampleroomandretrofit.modules.ship

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.application.SampleRoomDatabaseAndRetrofitApplication
import com.nick.sampleroomandretrofit.database.models.ShipsModel
import com.nick.sampleroomandretrofit.utils.base_classes.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ShipDetailsViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    var shipDetails = MutableLiveData<ShipsModel>()

    fun getSpecificShipById(shipId: String) {
        if (shipId != "") {
            launch {
                loading.value = true
                var shipsModel: ShipsModel
                withContext(Dispatchers.IO) {
                    shipsModel = myRoomDatabase.shipDao().getShipById(shipId)
                }
                loading.value = false
                shipDetails.value = shipsModel
            }
        } else {
            loading.value = false
            error.value = sampleRoomDatabaseAndRetrofitApplication.getString(R.string.something_went_wrong)
        }
    }
}