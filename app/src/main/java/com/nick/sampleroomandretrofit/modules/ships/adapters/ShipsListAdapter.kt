package com.nick.sampleroomandretrofit.modules.ships.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nick.sampleroomandretrofit.R
import com.nick.sampleroomandretrofit.database.models.ShipsModel
import com.nick.sampleroomandretrofit.databinding.ShipLayoutRecyclerViewBinding

class ShipsListAdapter(private var shipsModelList: MutableList<ShipsModel>, private var shipListener: ShipListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface ShipListener {
        fun onShipClick(shipId: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShipViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.ship_layout_recycler_view, parent, false))
    }

    fun load(shipsModelList: MutableList<ShipsModel>) {
        this.shipsModelList.clear()
        this.shipsModelList.addAll(shipsModelList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ShipViewHolder -> holder.bindData(shipsModelList[position])
        }
    }

    override fun getItemCount(): Int = shipsModelList.size

    private inner class ShipViewHolder(var view: ShipLayoutRecyclerViewBinding) : RecyclerView.ViewHolder(view.root), ShipListener {

        fun bindData(shipsModel: ShipsModel?) = with(view) {
            if (shipsModel != null) {
                ship = shipsModel
            }
            listener = this@ShipViewHolder
        }

        override fun onShipClick(shipId: String) {
            shipListener.onShipClick(shipId)
        }
    }
}