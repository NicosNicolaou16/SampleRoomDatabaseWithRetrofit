package com.nick.sampleroomandretrofit.modules.launcher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.application.SampleRoomDatabaseAndRetrofitApplication
import com.nick.sampleroomandretrofit.databinding.FragmentLauncherBinding
import com.nick.sampleroomandretrofit.utils.base_classes.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 * Use the [LauncherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class LauncherFragment : BaseFragment() {

    /**
     * ViewModelProvider(this).get(LauncherViewModel::class.java) or by viewModels() (KTX way)
     * */
    private val launcherViewModel: LauncherViewModel by viewModels()
    private var binding: FragmentLauncherBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_launcher, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLauncherBinding.bind(view)
        //launcherViewModel = ViewModelProvider(this).get(LauncherViewModel::class.java)

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