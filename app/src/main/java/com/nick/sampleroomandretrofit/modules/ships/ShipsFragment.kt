package com.nick.sampleroomandretrofit.modules.ships

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.databinding.FragmentShipsBinding
import com.nick.sampleroomandretrofit.modules.ships.adapters.ShipsListAdapter
import com.nick.sampleroomandretrofit.utils.base_classes.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Use the [ShipsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShipsFragment : BaseFragment(), ShipsListAdapter.ShipListener {

    private lateinit var shipsViewModel: ShipsViewModel
    private var shipsListAdapter: ShipsListAdapter? = null
    private var binding: FragmentShipsBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ships, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShipsBinding.bind(view)
        shipsViewModel = ViewModelProvider(this).get(ShipsViewModel::class.java)

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
        binding?.shipsList?.apply {
            adapter = shipsListAdapter
        }
    }

    override fun onShipClick(shipId: String) {
        val action = ShipsFragmentDirections.actionShipsFragmentToShipDetailsFragment(shipId)
        view?.let { Navigation.findNavController(it).navigate(action) }
    }
}