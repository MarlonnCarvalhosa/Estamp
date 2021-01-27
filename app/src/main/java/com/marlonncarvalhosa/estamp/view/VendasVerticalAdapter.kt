package com.marlonncarvalhosa.estamp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marlonncarvalhosa.estamp.R
import kotlinx.android.synthetic.main.anos.view.*

class VendasVerticalAdapter : RecyclerView.Adapter<VendasVerticalAdapter.VerticalHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalHolder = VerticalHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.anos, parent, false))

    override fun onBindViewHolder(holder: VerticalHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 1

    class VerticalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind() {
            with(itemView){
                this.rv_horizontal.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                this.rv_horizontal.adapter = MesHorizontalAdapter()
            }
        }
    }
}