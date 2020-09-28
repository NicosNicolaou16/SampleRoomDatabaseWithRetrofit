package com.nick.sampleroomandretrofit.modules.ship

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.application.SampleRoomDatabaseAndRetrofitApplication
import com.nick.sampleroomandretrofit.database.models.ShipsModel
import com.nick.sampleroomandretrofit.databinding.FragmentShipDetailsBinding
import com.nick.sampleroomandretrofit.utils.base_classes.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Use the [ShipDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShipDetailsFragment : BaseFragment() {

    private val shipDetailsViewModel = ShipDetailsViewModel(SampleRoomDatabaseAndRetrofitApplication.getInstance())
    private lateinit var bindData: FragmentShipDetailsBinding
    private var shipId: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        bindData = DataBindingUtil.inflate(inflater, R.layout.fragment_ship_details, container, false)
        return bindData.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        getIntentData()
        initObservable()
        queryShipData()
    }

    private fun getIntentData() {
        arguments?.let { this.shipId = ShipDetailsFragmentArgs.fromBundle(it).shipId ?: "" }
    }

    private fun queryShipData() {
        shipDetailsViewModel.getSpecificShipById(this.shipId)
    }

    private fun initObservable() {
        shipDetailsViewModel.shipDetails.observe(viewLifecycleOwner, Observer {
            setShipData(it)
        })

        shipDetailsViewModel.loading.observe(viewLifecycleOwner, Observer {
            if (it) startDefaultLoading() else stopLoading()
        })

        shipDetailsViewModel.error.observe(viewLifecycleOwner, Observer {
            showError(it)
        })
    }

    private fun setShipData(shipsModel: ShipsModel?) {
        if (shipsModel != null) {
            bindData.ship = shipsModel
        }
    }
}