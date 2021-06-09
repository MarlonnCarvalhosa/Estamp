package com.marlonncarvalhosa.estamp.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import com.marlonncarvalhosa.estamp.R
import com.marlonncarvalhosa.estamp.repository.Repository
import kotlinx.android.synthetic.main.dialog_salvar_venda.*

class SalvarVendaDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.dialog_salvar_venda, container, false)


        root.findViewById<TextView>(R.id.btn_salvar_venda).setOnClickListener {
            val nome: String = root.findViewById<Spinner>(R.id.spn_produtos).getSelectedItem().toString()
            val quantidade: String = root.findViewById<EditText>(R.id.edt_quantidade_produto).text.toString()
            val precoOpticional: String = root.findViewById<EditText>(R.id.edt_preco_promocional).text.toString()
            val nomeCliente: String = root.findViewById<EditText>(R.id.edt_nome_cliente).text.toString()

            Repository().createItemMonth(nome, quantidade.toInt(), nomeCliente, precoOpticional.toDouble())

            dialog?.dismiss()
        }

        root.findViewById<TextView>(R.id.btn_cancelar_venda).setOnClickListener {
            dialog?.dismiss()
        }

        root.findViewById<ImageView>(R.id.iv_button_hide_price).setOnClickListener {
            hidePrice()
        }



        return root
    }

    fun hidePrice() {
        input_layout_preco_promocional?.isVisible = input_layout_preco_promocional?.visibility != View.VISIBLE
        edt_preco_promocional?.isVisible = edt_preco_promocional?.visibility != View.VISIBLE

        if(input_layout_preco_promocional?.visibility != View.VISIBLE) {
            iv_button_hide_price.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
        } else {
            iv_button_hide_price.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
        }
    }
}