package com.marlonncarvalhosa.estamp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marlonncarvalhosa.estamp.model.AnoModel
import com.marlonncarvalhosa.estamp.repository.Repository

class VendasViewModel : ViewModel() {

    private val mRepository = Repository()
    fun anosData(): LiveData<MutableList<AnoModel>> {
        val mutableData = MutableLiveData<MutableList<AnoModel>>()
        mRepository.getAnoData().observeForever {
            mutableData.value = it
        }

        return mutableData
    }
}