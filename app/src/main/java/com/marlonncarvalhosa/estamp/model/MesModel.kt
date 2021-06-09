package com.marlonncarvalhosa.estamp.model

import com.google.firebase.Timestamp

data class MesModel(
    var idMes: String? = null,
    var nomeDoMes: String? = null,
    var timestamp: Timestamp? = null
)