package com.marlonncarvalhosa.estamp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.marlonncarvalhosa.estamp.R
import com.marlonncarvalhosa.estamp.adapter.VendasVerticalAdapter
import com.marlonncarvalhosa.estamp.viewmodel.VendasViewModel

class VendasFragment : Fragment() {

    private lateinit var vendasViewModel: VendasViewModel
    private var vendasVerticalAdapter: VendasVerticalAdapter? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_vendas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vendasVerticalAdapter = VendasVerticalAdapter()
        view.findViewById<RecyclerView>(R.id.rv_vertical).adapter = vendasVerticalAdapter
    }
}