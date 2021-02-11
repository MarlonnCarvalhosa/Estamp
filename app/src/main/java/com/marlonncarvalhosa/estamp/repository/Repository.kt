package com.marlonncarvalhosa.estamp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.marlonncarvalhosa.estamp.model.AnoModel

class Repository {

    fun getAnoData(): LiveData<MutableList<AnoModel>> {
        val mutableData = MutableLiveData<MutableList<AnoModel>>()
        FirebaseFirestore.getInstance().collection("Anos").get().addOnSuccessListener {

            val listData = mutableListOf<AnoModel>()
            for(ano in it){
                val anoAtual = ano.getString("anoAtual")
                val rendaAnual = ano.getString("rendaAnual")
                val anos = AnoModel(anoAtual!!, rendaAnual!!)
                listData.add(anos)
            }
            mutableData.value = listData
        }

        return mutableData
    }
}