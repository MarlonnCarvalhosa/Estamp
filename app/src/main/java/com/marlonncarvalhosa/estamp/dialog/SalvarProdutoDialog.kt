package com.marlonncarvalhosa.estamp.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.marlonncarvalhosa.estamp.R
import com.marlonncarvalhosa.estamp.repository.Repository

class SalvarProdutoDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.dialog_salvar_produto, container, false)

        root.findViewById<CardView>(R.id.cv_finish_product).setOnClickListener {
            Toast.makeText(context, "Finish", Toast.LENGTH_LONG).show()
            dialog?.dismiss()
        }

        root.findViewById<CardView>(R.id.cv_cancel_product).setOnClickListener {
            dialog?.dismiss()
        }

        return root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
    }
}