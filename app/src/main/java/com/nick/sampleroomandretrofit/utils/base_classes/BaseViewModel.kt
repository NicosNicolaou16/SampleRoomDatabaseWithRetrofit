package com.nick.sampleroomandretrofit.utils.base_classes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nick.sampleroomandretrofit.database.init_database.MyRoomDatabase
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.application.SampleRoomDatabaseAndRetrofitApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private val job = Job()
    internal val loading = MutableLiveData<Boolean>()
    internal val error = MutableLiveData<String>()

    @Inject
    protected lateinit var myRoomDatabase: MyRoomDatabase
    @Inject
    protected lateinit var sampleRoomDatabaseAndRetrofitApplication: SampleRoomDatabaseAndRetrofitApplication

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    protected fun handleErrorMessage(e: Throwable): String {
        val application = getApplication<SampleRoomDatabaseAndRetrofitApplication>()
        return when (e) {
            is HttpException -> {
                val responseBody: ResponseBody? = e.response()?.errorBody()
                val errorMessage = responseBody?.let { getErrorMessage(it.string()) }
                        ?: getApplication<SampleRoomDatabaseAndRetrofitApplication>().getString(R.string.something_went_wrong)
                errorMessage
            }
            is SocketTimeoutException -> {
                application.getString(R.string.something_went_wrong_with_server)
            }
            is IOException -> {
                application.getString(R.string.check_your_internet_connection)
            }
            else -> {
                e.message ?: application.getString(R.string.something_went_wrong)
            }
        }
    }

    private fun getErrorMessage(handleErrorMessage: String): String? {
        val application = getApplication<SampleRoomDatabaseAndRetrofitApplication>()
        return try {
            val jsonObject = JSONObject(handleErrorMessage)
            val jsonArray = JSONArray(handleErrorMessage)
            jsonObject.optString("message")//depend from server the json key - this is an example
        } catch (e: Exception) {
            e.message
            application.getString(R.string.something_went_wrong)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}