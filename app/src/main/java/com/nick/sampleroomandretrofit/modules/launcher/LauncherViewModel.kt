package com.nick.sampleroomandretrofit.modules.launcher

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.nick.sampleroomandretrofit.utils.base_classes.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LauncherViewModel(application: Application) : BaseViewModel(application) {

    val startMainScreen = MutableLiveData<Boolean>()

    companion object {
        private const val DELAY = 1500L
    }

    fun startMainScreen() {
        launch {
            withContext(Dispatchers.IO) {
                delay(DELAY)
            }
            startMainScreen.value = true
        }
    }

}