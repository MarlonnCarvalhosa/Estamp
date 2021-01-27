package com.marlonncarvalhosa.estamp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProdutosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Podutos"
    }
    val text: LiveData<String> = _text
}