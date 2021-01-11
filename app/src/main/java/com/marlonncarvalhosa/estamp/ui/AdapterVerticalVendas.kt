package com.marlonncarvalhosa.estamp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marlonncarvalhosa.estamp.R

class AdapterVerticalVendas : RecyclerView.Adapter<AdapterVerticalVendas.VerticalHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalHolder = VerticalHolder(LayoutInflater.from(parent.context).inflate(R.layout.anos, parent, false))

    override fun onBindViewHolder(holder: VerticalHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 10

    class VerticalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind() {
            with(itemView){
                this.findViewById<RecyclerView>(R.id.rvHorizontal).layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false
            }
        }
    }
}