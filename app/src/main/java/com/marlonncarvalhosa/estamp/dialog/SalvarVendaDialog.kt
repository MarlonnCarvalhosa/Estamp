package com.marlonncarvalhosa.estamp.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import com.marlonncarvalhosa.estamp.R
import com.marlonncarvalhosa.estamp.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class SalvarVendaDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.dialog_salvar_venda, container, false)

        root.findViewById<CardView>(R.id.cv_finish).setOnClickListener {
            val nomeProduto: Spinner = root.findViewById(R.id.spn_produtos)
            val quantidade: EditText = root.findViewById(R.id.edt_quantidade_produto)
            val precoOpticional: EditText = root.findViewById(R.id.edt_preco_promocional)
            val nomeCliente: EditText = root.findViewById(R.id.edt_nome_cliente)

            if (nomeCliente.text?.isEmpty() == true){
                nomeCliente.error = "Insira o nome do cliente"
                return@setOnClickListener
            }

            if (precoOpticional.text?.isEmpty() == true){
                precoOpticional.error = "Insira um preço"
                return@setOnClickListener
            }

            Repository().createItemMonth(
                nomeProduto.selectedItem.toString(),
                quantidade.text.toString().toInt(),
                nomeCliente.text.toString(),
                precoOpticional.text.toString().toDouble()
            )

            dialog?.dismiss()
        }

        root.findViewById<CardView>(R.id.cv_cancel).setOnClickListener {
            dialog?.dismiss()
        }

        return root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
    }
}