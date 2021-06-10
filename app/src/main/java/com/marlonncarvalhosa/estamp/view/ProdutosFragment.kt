package com.marlonncarvalhosa.estamp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.marlonncarvalhosa.estamp.R
import com.marlonncarvalhosa.estamp.dialog.SalvarProdutoDialog
import com.marlonncarvalhosa.estamp.dialog.SalvarVendaDialog
import kotlinx.android.synthetic.main.fragment_produtos.view.*
import kotlinx.android.synthetic.main.fragment_vendas.view.*

class ProdutosFragment : Fragment() {

    private var mDatabase: DatabaseReference? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_produtos, container, false)

        mDatabase = FirebaseDatabase.getInstance().reference

        root.fb_add_product.setOnClickListener {
            val dialog = SalvarProdutoDialog()
            fragmentManager?.let { it1 -> dialog.show(it1, "DialogSalvarVenda") }
        }
        return root
    }
}