package com.marlonncarvalhosa.estamp.repository

import android.util.Log
import com.google.android.gms.tasks.Tasks
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.marlonncarvalhosa.estamp.model.MesModel
import java.text.SimpleDateFormat
import java.util.*

class Repository {
    private val db = FirebaseFirestore.getInstance()

    private fun currentYear(): String {
        val cal = Calendar.getInstance()
        val year_date = SimpleDateFormat("yyyy")
        cal[Calendar.YEAR]
        val anoAtual = year_date.format(cal.time)

        return anoAtual
    }

    private fun currentMonth(): String {
        val brasil = Locale("pt", "BR")
        val cal = Calendar.getInstance(brasil)
        val month_date = SimpleDateFormat("MMMM")
        cal[Calendar.MONTH]
        val monthtual = month_date.format(cal.time)

        return monthtual
    }


    fun createYearMonth() {
        // CRIANDO ANO E MES

        if(true){
            return
        }

        val item = hashMapOf<String, Any>()

        item["nomeDoMes"] = currentMonth()
        item["timestamp"] = Timestamp.now()

        db.collection(currentYear())
        .add(item)
        .addOnSuccessListener {
            Log.d("CREATE_FIREBASE", "OnSuccess Created id: ${it.id}")
            return@addOnSuccessListener
        }
        .addOnFailureListener {
            e -> Log.w("CREATE_FIREBASE", "OnFailure Update: ", e)
            return@addOnFailureListener
        }
    }

    fun getYear(): MutableList<MesModel> {
        val newList = mutableListOf<MesModel>()
        val listsRef = FirebaseFirestore.getInstance()
        val docRef = listsRef
            .collection(currentYear())
            .orderBy("timestamp", Query.Direction.ASCENDING)

        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                Log.w("GET_FIREBASE", "Listen failed.", e)
                return@addSnapshotListener
            }
            if (snapshot?.isEmpty == true) {
                newList.clear()
                Log.w("GET_FIREBASE", "Lista Vazia")
                return@addSnapshotListener
            }

            for (dc in snapshot!!.documentChanges) {
                dc.document.toObject(MesModel::class.java).let { entity ->
                    entity.idMes = dc.document.id
                    newList.add(entity)
                    Log.d("GET_FIREBASE", "Get Item: $entity")
                }
            }
        }

        return newList

    }


}