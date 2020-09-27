package com.nick.sampleroomandretrofit.modules.ships

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.application.SampleRoomDatabaseAndRetrofitApplication
import com.nick.sampleroomandretrofit.modules.ships.adapters.ShipsListAdapter
import com.nick.sampleroomandretrofit.utils.base_classes.BaseFragment
import kotlinx.android.synthetic.main.fragment_ships.*

/**
 * A simple [Fragment] subclass.
 * Use the [ShipsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShipsFragment : BaseFragment(), ShipsListAdapter.ShipListener {

    private var shipsViewModel = ShipsViewModel(SampleRoomDatabaseAndRetrofitApplication.getInstance())
    private var shipsListAdapter: ShipsListAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ships, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        initAdapter()
        initObservables()
    }

    private fun initObservables() {
        shipsViewModel.ships.observe(viewLifecycleOwner, Observer {
            shipsListAdapter?.load(it)
        })

        shipsViewModel.loading.observe(viewLifecycleOwner, Observer {
            if (it) startDefaultLoading() else stopLoading()
        })

        shipsViewModel.error.observe(viewLifecycleOwner, Observer {
            showError(it)
        })
    }

    private fun initAdapter() {
        shipsListAdapter = ShipsListAdapter(mutableListOf(), this)
        shipsList.apply {
            adapter = shipsListAdapter
        }
    }

    override fun onShipClick(shipId: String) {
        val action = ShipsFragmentDirections.actionShipsFragmentToShipDetailsFragment(shipId)
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}