package com.marlonncarvalhosa.estamp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.marlonncarvalhosa.estamp.R
import com.marlonncarvalhosa.estamp.adapter.AnosVerticalAdapter
import com.marlonncarvalhosa.estamp.model.AnoModel
import com.marlonncarvalhosa.estamp.model.MesModel
import com.marlonncarvalhosa.estamp.repository.Repository
import java.text.SimpleDateFormat
import java.util.*

class VendasFragment : Fragment() {

    private var mDatabase: DatabaseReference? = null
    private var mMesDataBase: DatabaseReference? = null
    private lateinit var mDataList: MutableList<AnoModel>
    private var mAnosVerticalAdapter: AnosVerticalAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mDataList = mutableListOf()
        mDatabase = FirebaseDatabase.getInstance().reference
        return inflater.inflate(R.layout.fragment_vendas, container, false)
    }

    override fun onResume() {
        val db = Repository()

        db.createYearMonth()

        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAnosVerticalAdapter = activity?.let { AnosVerticalAdapter(mDataList, it.applicationContext) }
        view.findViewById<RecyclerView>(R.id.rv_vertical).adapter = mAnosVerticalAdapter
    }


}


// VENDAS
//db.collection(currentYear())
//.document(currentMonth())
//.collection("vendas")
//.add(idItem)
//.addOnSuccessListener {
//    Log.d("UPDATE_COMPRADO", "OnSuccess Update:")
//    return@addOnSuccessListener
//}
//.addOnFailureListener {
//    e -> Log.w("UPDATE_COMPRADO", "OnFailure Update: ", e)
//    return@addOnFailureListener
//}