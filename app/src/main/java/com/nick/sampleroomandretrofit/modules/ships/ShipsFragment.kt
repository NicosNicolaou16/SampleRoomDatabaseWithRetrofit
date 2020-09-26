package com.nick.sampleroomandretrofit.modules.ships

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.utils.base_classes.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Use the [ShipsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShipsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ships, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}