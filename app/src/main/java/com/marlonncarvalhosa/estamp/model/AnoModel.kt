package com.marlonncarvalhosa.estamp.model

import java.text.SimpleDateFormat
import java.time.Month
import java.util.*

data class AnoModel(
    val id: String? = "",
    val anoAtual: String? = "",
    val rendaAnual: String? = ""

)

    fun currentYear() {
        val cal = Calendar.getInstance()
        val month_date = SimpleDateFormat("MMMM")
        cal[Calendar.MONTH]
        val anoAtual = month_date.format(cal.time)
    }


