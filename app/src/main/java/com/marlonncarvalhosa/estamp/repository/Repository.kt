package com.marlonncarvalhosa.estamp.repository

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.marlonncarvalhosa.estamp.model.MesModel
import com.marlonncarvalhosa.estamp.model.ProdutoModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class Repository {
    private val db = FirebaseFirestore.getInstance()

    fun currentYear(): String {
        val cal = Calendar.getInstance()
        val year_date = SimpleDateFormat("yyyy")
        cal[Calendar.YEAR]
        val anoAtual = year_date.format(cal.time)

        return anoAtual
    }

    fun currentMonth(): String {
        val brasil = Locale("pt", "BR")
        val cal = Calendar.getInstance(brasil)
        val month_date = SimpleDateFormat("MMMM")
        cal[Calendar.MONTH]
        val monthtual = month_date.format(cal.time)

        return monthtual
    }

    fun createItemMonth(nome: String, qt: Int, cliente: String, valor: Double){

        val mes = hashMapOf<String, Any>()

        mes["totalMes"] = 0.00
        mes["timestamp"] = Timestamp.now()


        db.collection("estamp")
            .document(currentYear())
            .collection("meses")
            .document(currentMonth())
            .set(mes)
            .addOnSuccessListener {

                val venda = hashMapOf<String, Any>()

                venda["produto"] = nome
                venda["timestamp"] = Timestamp.now()
                venda["quantidade"] = qt
                venda["cliente"] = cliente
                venda["valor"] = (qt * valor)

                db.collection("estamp")
                    .document(currentYear())
                    .collection("meses")
                    .document(currentMonth())
                    .collection("vendas")
                    .add(venda)
                    .addOnSuccessListener {
                        sumSale(currentYear(), currentMonth())
                        Log.i("VENDA", "sucesso")
                    }

                Log.i("VENDA", "sucesso")
            }
    }

    fun createYearMonth() {
        val item = hashMapOf<String, Any>()

        item["timestamp"] = Timestamp.now()
        item["totalAno"] = 0.00

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

    fun sumSale(ano: String, mes: String): Double {
        var totalMes = 0.00

        db.collection("estamp")
            .document(ano)
            .collection("meses")
            .document(mes)
            .collection("vendas")
            .get()
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    var mDataList: List<ProdutoModel> = ArrayList()
                    mDataList = task.result!!.toObjects(ProdutoModel::class.java)
                    mDataList.map {
                        totalMes += it.valor!!.toDouble()
                    }

                    updateMes(ano, mes, totalMes){

                        updateAno(ano, totalMes){

                        }
                    }
                    
                    Log.i("SUMSALE-VENDAS", "sucesso $totalMes")
                }
            }

        return totalMes
    }

    fun updateMes(ano: String, mes: String, totalMes: Double, myCallback: (result: Double?) -> Unit){
        val updateMes = hashMapOf<String?, Any?>(
            "totalMes" to totalMes
        )

        db.collection("estamp")
            .document(ano)
            .collection("meses")
            .document(mes)
            .update(updateMes)
            .addOnCompleteListener {
                myCallback(null)
            }
    }

    fun updateAno(ano: String, totalMes: Double, myCallback: (result: Double?) -> Unit){
        val updateAno = hashMapOf<String?, Any?>(
            "totalAno" to totalMes
        )
        var totalAno = 0.00

        db.collection("estamp")
            .document(ano)
            .collection("meses")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    var mDataList: List<MesModel> = ArrayList()
                    mDataList = task.result!!.toObjects(MesModel::class.java)
                    mDataList.map {
                        totalAno += it.totalMes!!.toDouble()
                    }


                    db.collection("estamp")
                        .document(ano)
                        .update(updateAno)
                        .addOnCompleteListener {
                            myCallback(null)
                        }
                }
            }
    }

    fun getYearList(): Query {
        return db.collection("estamp")
            .orderBy("timestamp", Query.Direction.DESCENDING)
    }

    fun getMonthList(Ano: String): Query {
        return db.collection("estamp")
            .document(Ano)
            .collection("meses")
            .orderBy("timestamp", Query.Direction.DESCENDING)
    }

    fun getYearMonthList(Ano: String, myCallback: (result: Double?) -> Unit) {
        db.collection("estamp")
            .document(Ano)
            .collection("meses")
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .get()
            .addOnCompleteListener { meses ->
                if(meses.isSuccessful){
                    var sumMonth: Double = 0.00
                    val listTempMeses: List<MesModel> = meses.result!!.toObjects(MesModel::class.java)
                    listTempMeses.map { valoresMes ->
                        sumMonth += valoresMes.totalMes!!.toDouble()
                    }

                    myCallback(sumMonth)
                }
            }
    }

    fun getMonthVendasList(Ano: String, Mes: String): Task<QuerySnapshot> {
        return db.collection("estamp")
            .document(Ano)
            .collection("meses")
            .document(Mes)
            .collection("vendas")
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .get()
    }
    
}