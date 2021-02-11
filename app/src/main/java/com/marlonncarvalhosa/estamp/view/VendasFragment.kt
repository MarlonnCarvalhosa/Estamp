package com.marlonncarvalhosa.estamp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.marlonncarvalhosa.estamp.R
import com.marlonncarvalhosa.estamp.adapter.AnosVerticalAdapter
import com.marlonncarvalhosa.estamp.model.AnoModel
import com.marlonncarvalhosa.estamp.viewmodel.VendasViewModel

class VendasFragment : Fragment() {

    private var anosVerticalAdapter: AnosVerticalAdapter? = null
    private val mViewModel by lazy { ViewModelProvider(this).get(VendasViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vendas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        anosVerticalAdapter = activity?.let { AnosVerticalAdapter(it.applicationContext) }
        view.findViewById<RecyclerView>(R.id.rv_vertical).adapter = anosVerticalAdapter

    }

    

    fun observeData(){
        mViewModel.anosData()
    }
}