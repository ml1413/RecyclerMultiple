package com.ooommm.recyclermultiple

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerHumanAdapter : RecyclerView.Adapter<RecyclerHumanAdapter.HumanViewHolder>() {
    var humanList = emptyList<Human>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class HumanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var lastname: TextView = itemView.findViewById(R.id.tv_last_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HumanViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rv, parent, false)
        return HumanViewHolder(view)
    }

    override fun onBindViewHolder(holder: HumanViewHolder, position: Int) {
        val item = humanList[position]
        holder.name.text = item.name
        holder.lastname.text = item.lastName
    }

    override fun getItemCount() = humanList.size
}