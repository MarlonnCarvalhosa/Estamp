package com.marlonncarvalhosa.estamp.ui.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VendasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Vendas"
    }
    val text: LiveData<String> = _text
}