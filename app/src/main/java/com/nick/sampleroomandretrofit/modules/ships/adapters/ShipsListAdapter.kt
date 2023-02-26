package com.nick.sampleroomandretrofit.modules.ships.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.databinding.ShipLayoutRecyclerViewBinding
import com.nick.sampleroomandretrofit.modules.ships.models.ShipsDataModel

class ShipsListAdapter(
    private var shipsDataModelList: MutableList<ShipsDataModel>,
    private var shipListener: ShipListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface ShipListener {
        fun onShipClick(shipId: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShipViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.ship_layout_recycler_view,
                parent,
                false
            )
        )
    }

    fun load(shipsDataModelList: MutableList<ShipsDataModel>) {
        this.shipsDataModelList.clear()
        this.shipsDataModelList.addAll(shipsDataModelList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ShipViewHolder -> holder.bindData(shipsDataModelList[position])
        }
    }

    override fun getItemCount(): Int = shipsDataModelList.size

    private inner class ShipViewHolder(var view: ShipLayoutRecyclerViewBinding) :
        RecyclerView.ViewHolder(view.root) {

        fun bindData(shipsDataModel: ShipsDataModel?) = with(view) {
            if (shipsDataModel != null) {
                ship = shipsDataModel.shipsModel
            }
            listener = shipListener
        }
    }
}