package com.marlonncarvalhosa.estamp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marlonncarvalhosa.estamp.R
import com.marlonncarvalhosa.estamp.model.AnoModel
import kotlinx.android.synthetic.main.item_anos.view.*

class AnosVerticalAdapter(private val mDataList: MutableList<AnoModel>, private val context: Context) :
    RecyclerView.Adapter<AnosVerticalAdapter.VerticalHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalHolder =
        VerticalHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_anos, parent, false
            )
        )

    override fun getItemCount(): Int {
        return if (mDataList.isEmpty()) 0 else mDataList.size
    }

    inner class VerticalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(ano: AnoModel) {

        }
    }

    override fun onBindViewHolder(holder: VerticalHolder, position: Int) {
        holder.bind(mDataList[position])
    }
}