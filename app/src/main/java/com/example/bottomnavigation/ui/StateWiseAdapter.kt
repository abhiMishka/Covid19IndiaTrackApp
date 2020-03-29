package com.example.bottomnavigation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomnavigation.R
import com.example.bottomnavigation.network.dataclasses.AllDataResponse
import kotlinx.android.synthetic.main.item_state.view.*


class StateWiseAdapter(val conFeeData: List<AllDataResponse.Statewise>,
                       val itemClickListener: ItemSelectListener)
    : androidx.recyclerview.widget.RecyclerView.Adapter<StateWiseAdapter.PaymentModeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentModeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_state, parent, false)
        return PaymentModeViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int {
        return conFeeData.size
    }

    override fun onBindViewHolder(holder: PaymentModeViewHolder, position: Int) {
        holder.setData(conFeeData[position], position)
    }

    class PaymentModeViewHolder(itemView: View, itemClickListener: ItemSelectListener) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val context = itemView.context!!
        val listener = itemClickListener
        fun setData(data: AllDataResponse.Statewise, position: Int) {
            itemView.deltaStateTv.text = data.delta.confirmed.toString()
            itemView.confirmedVaueTv.text = data.confirmed
            itemView.activeVaueTv.text = data.active
            itemView.deathsVaueTv.text = data.deaths
            itemView.recoveredVaueTv.text = data.recovered
            itemView.stateNameTv.text = data.state
            itemView.setOnClickListener {
                listener.onItemClick(data, position)
            }
        }
    }


}