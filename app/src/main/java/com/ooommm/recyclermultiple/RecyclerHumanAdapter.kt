package com.ooommm.recyclermultiple

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RecyclerHumanAdapter(private val context: Context, private val cvDelete: CardView) :
    RecyclerView.Adapter<RecyclerHumanAdapter.HumanViewHolder>() {
    private var visibilityDelete = 0
    var isLongPress: Boolean = false

    var humanList = emptyList<Human>()
        set(value) {
            field = value
            notifyDataSetChanged()
            visibilityDelete = 0
        }
    val humanDeleteList
        get() = humanList.filter { it.isSetColor }


    class HumanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)
        var lastname: TextView = itemView.findViewById(R.id.tv_last_name)
        var cardView: CardView = itemView.findViewById(R.id.card_view)
        var linearLayout: LinearLayout = itemView.findViewById(R.id.ll_container)
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
        holder.linearLayout.background = null

        holder.cardView.setOnLongClickListener {
            cvDelete.visibility = View.VISIBLE
            isLongPress = true
            false
        }

        holder.cardView.setOnClickListener {
            if (isLongPress) {
                if (!humanList[position].isSetColor) {
                    holder.linearLayout.setBackgroundColor(
                        ContextCompat.getColor(context, R.color.red)
                    )
                    humanList[position].isSetColor = true
                    visibilityDelete++
                    visibilityDelete()
                } else {
                    holder.linearLayout.background = null
                    humanList[position].isSetColor = false
                    visibilityDelete--
                    visibilityDelete()
                }
            }
        }

    }

    override fun getItemCount() = humanList.size

    private fun visibilityDelete() {
        if (visibilityDelete > 0) {
            cvDelete.visibility = View.VISIBLE
        } else {
            cvDelete.visibility = View.GONE
        }
    }
}