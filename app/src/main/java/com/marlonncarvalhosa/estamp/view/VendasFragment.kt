package com.marlonncarvalhosa.estamp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.marlonncarvalhosa.estamp.R
import com.marlonncarvalhosa.estamp.databinding.FragmentVendasBinding
import com.marlonncarvalhosa.estamp.dialog.SalvarVendaDialog

class VendasFragment : Fragment(R.layout.fragment_vendas) {
    private var binding: FragmentVendasBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): ConstraintLayout? {
        binding = FragmentVendasBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.fbAddSale?.setOnClickListener {
            val dialog = SalvarVendaDialog()
            fragmentManager?.let { it1 -> dialog.show(it1, "DialogSalvarVenda") }
        }
    }

}