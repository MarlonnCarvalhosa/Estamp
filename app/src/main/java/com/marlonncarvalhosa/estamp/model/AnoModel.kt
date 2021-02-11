package com.marlonncarvalhosa.estamp.model

import java.text.SimpleDateFormat
import java.util.*

data class AnoModel(
    val id: String? = "",
    val anoAtual: String,
    val rendaAnual: String? = ""
)

    fun currentDate() {
        val cal = Calendar.getInstance()
        val year = SimpleDateFormat("MMMM")
        cal[Calendar.YEAR]
        val anoAtual = year.format(cal.time)
    }