package com.nick.sampleroomandretrofit.modules.launcher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.application.SampleRoomDatabaseAndRetrofitApplication
import com.nick.sampleroomandretrofit.utils.base_classes.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Use the [LauncherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LauncherFragment : BaseFragment() {

    private var launcherViewModel = LauncherViewModel(SampleRoomDatabaseAndRetrofitApplication.getInstance())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_launcher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        launcherViewModel.startMainScreen()
        initObservables()
    }

    private fun initObservables() {
        launcherViewModel.startMainScreen.observe(viewLifecycleOwner, Observer {
            if (it)
                view?.let { it1 -> Navigation.findNavController(it1).navigate(LauncherFragmentDirections.actionLauncherFragmentToShipsFragment()) }
            else
                showError(getString(R.string.something_went_wrong))
        })
    }
}