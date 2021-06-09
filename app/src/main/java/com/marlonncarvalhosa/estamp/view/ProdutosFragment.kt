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

class ProdutosFragment : Fragment() {

    private var mDatabase: DatabaseReference? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mDatabase = FirebaseDatabase.getInstance().reference
        return inflater.inflate(R.layout.fragment_vendas, container, false)
    }
}