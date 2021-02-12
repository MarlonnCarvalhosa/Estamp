package com.marlonncarvalhosa.estamp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.marlonncarvalhosa.estamp.R
import com.marlonncarvalhosa.estamp.adapter.AnosVerticalAdapter
import com.marlonncarvalhosa.estamp.model.AnoModel
import com.marlonncarvalhosa.estamp.model.MesModel
import com.marlonncarvalhosa.estamp.viewmodel.VendasViewModel
import java.text.SimpleDateFormat
import java.util.*

class VendasFragment : Fragment() {

    private var mDatabase: DatabaseReference? = null
    private var mMesDataBase: DatabaseReference? = null
    private var mAnosVerticalAdapter: AnosVerticalAdapter? = null
    private val mViewModel by lazy { ViewModelProvider(this).get(VendasViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mDatabase = FirebaseDatabase.getInstance().reference
        return inflater.inflate(R.layout.fragment_vendas, container, false)
    }

    override fun onResume() {
        iniciarAno()
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAnosVerticalAdapter = activity?.let { AnosVerticalAdapter(it.applicationContext) }
        view.findViewById<RecyclerView>(R.id.rv_vertical).adapter = mAnosVerticalAdapter
    }

    private fun currentYear(): String {
        val cal = Calendar.getInstance()
        val year_date = SimpleDateFormat("yyyy")
        cal[Calendar.YEAR]
        val anoAtual = year_date.format(cal.time)

        return anoAtual
    }

    private fun currentMonth(): String {
        val cal = Calendar.getInstance()
        val month_date = SimpleDateFormat("MMMM")
        cal[Calendar.MONTH]
        val monthtual = month_date.format(cal.time)

        return monthtual
    }

    private fun iniciarAno() {
        if (currentYear() == currentYear() && currentMonth() == currentMonth()) {
            val anos = AnoModel(currentYear(), rendaAnual = "500")
            val mes = MesModel(currentMonth(), rendaMensal = "100")
            mDatabase!!.child("Anos").child(currentYear()).setValue(anos)
            mDatabase!!.child("Anos").child(currentYear()).child(currentMonth()).setValue(mes)
        }
    }

}