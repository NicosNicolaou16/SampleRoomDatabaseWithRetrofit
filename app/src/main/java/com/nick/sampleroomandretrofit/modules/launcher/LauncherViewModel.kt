package com.nick.sampleroomandretrofit.modules.launcher

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.nick.sampleroomandretrofit.utils.base_classes.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LauncherViewModel @Inject constructor(application: Application) : BaseViewModel(application) {

    val startMainScreen = MutableLiveData<Boolean>()

    companion object {
        private const val DELAY = 1500L
    }

    fun startMainScreen() {
        launch {
            withContext(Dispatchers.Default) {
                delay(DELAY)
            }
            startMainScreen.value = true
        }
    }
}