package com.marlonncarvalhosa.estamp.repository

import android.text.Editable
import android.util.Log
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.marlonncarvalhosa.estamp.model.AnoModel
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

    fun createItemMonth(nome: String, qt: Int, cliente: String, valor: Double){

        val venda = hashMapOf<String, Any>()

        venda["produto"] = nome
        venda["timestamp"] = Timestamp.now()
        venda["quantidade"] = qt
        venda["cliente"] = cliente
        venda["valor"] = valor

        db.collection("estamp")
            .document(currentYear())
            .collection(currentMonth())
            .add(venda)
            .addOnSuccessListener {
                Log.i("VENDA", "sucesso")
            }
    }

    fun createYearMonth() {
        val item = hashMapOf<String, Any>()

        item["timestamp"] = Timestamp.now()

        Log.i("NOTIFY_CREATE_FIREBASE", "CRIANDO NEWLIST")
        db.collection("estamp")
            .document(currentYear())
            .set(item)
            .addOnSuccessListener {
                Log.d("CREATE_FIREBASE", "OnSuccess Created id: ${it}")
            }
            .addOnFailureListener {
                    e -> Log.w("CREATE_FIREBASE", "OnFailure Update: ", e)
                return@addOnFailureListener
            }
    }

    fun getYear(myCalback: (MutableList<AnoModel>) -> Unit) {

        val listsRef = FirebaseFirestore.getInstance()
        listsRef
            .collection("estamp")
            .orderBy("timestamp", Query.Direction.ASCENDING)
            .get()
            .addOnSuccessListener {
                val newList = mutableListOf<AnoModel>()
                for (dc in it!!.documentChanges) {
                    dc.document.toObject(AnoModel::class.java).let { entity ->
                        entity.idAno = dc.document.id
                        newList.add(entity)
                    }
                }
                Log.d("GET_FIREBASE", "Get Itens: $newList")
                myCalback(newList)
            }
    }


}