package com.nick.sampleroomandretrofit.utils.base_classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.MainThread
import androidx.annotation.UiThread
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.nick.sampleroom.database.init_database.MyRoomDatabase
import com.nick.sampleroomandretrofit.R

abstract class BaseFragment : Fragment() {

    private var loadingProgressBar: AlertDialog.Builder? = null
    private var loadingShown: AlertDialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        MyRoomDatabase.destroyInstance()
        super.onDestroy()
    }

    override fun onPause() {
        stopLoading()
        super.onPause()
    }

    /**
     * this method uses to show the default progress bar (loading)
     * */
    @UiThread
    @MainThread
    protected fun startDefaultLoading() {
        stopLoading()
        val loadingView = LayoutInflater.from(this.requireContext()).inflate(R.layout.recommended_default_loading_layout, null)
        loadingProgressBar = this.requireContext().let { AlertDialog.Builder(it, R.style.CustomAlertDialog) }.apply {
            setView(loadingView)
            setCancelable(false)
            create()
            loadingShown = show()
        }
    }

    protected fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @UiThread
    @MainThread
    protected fun stopLoading() {
        loadingShown?.apply { dismiss() }
    }
}