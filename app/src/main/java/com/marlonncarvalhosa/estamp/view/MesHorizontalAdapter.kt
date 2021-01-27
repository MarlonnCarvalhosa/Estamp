package com.marlonncarvalhosa.estamp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.anos.view.*
import kotlinx.android.synthetic.main.meses.view.*

class MesHorizontalAdapter : RecyclerView.Adapter<MesHorizontalAdapter.HorizontalHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalHolder = HorizontalHolder(LayoutInflater.from(parent.context).inflate(R.layout.meses, parent, false))

    override fun onBindViewHolder(holder: HorizontalHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 12

    class HorizontalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind() {
            with(itemView){
            }

        }
    }
}