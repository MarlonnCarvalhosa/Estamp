package com.marlonncarvalhosa.estamp.model

import com.google.firebase.Timestamp

data class ProdutoModel(
    var idProduto: String? = null,
    var produto: String? = null,
    var cliente: String? = null,
    var quantidade: Int? = null,
    val valor: Double? = null,
    var timestamp: Timestamp? = null
)