package com.marlonncarvalhosa.estamp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marlonncarvalhosa.estamp.R
import com.marlonncarvalhosa.estamp.model.AnoModel
import kotlinx.android.synthetic.main.item_anos.view.*

class AnosVerticalAdapter(private val context: Context) :
    RecyclerView.Adapter<AnosVerticalAdapter.VerticalHolder>() {

    private var mDataList = mutableListOf<AnoModel>()

    fun setListData(data: MutableList<AnoModel>) {
        mDataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalHolder =
        VerticalHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_anos, parent, false
            )
        )

    override fun onBindViewHolder(holder: VerticalHolder, position: Int) {
        val ano: AnoModel = mDataList[position]
        holder.bind(ano)
    }

    override fun getItemCount(): Int {
        return if (mDataList.size > 0) {
            mDataList.size
        } else 0
    }

    inner class VerticalHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(ano: AnoModel) {
            itemView.txt_decimal_ano_atual.text = ano.AnoAtual
            itemView.txt_renda_anual.text = ano.rendaAnual.toString()
        }
    }
}