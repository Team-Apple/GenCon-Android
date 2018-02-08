package com.github.teamapple.gencon.util

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter


object DateFormatter {
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    fun format(year:Int, month: Int, day: Int): String{
       return LocalDate.of(year,month,day).format(formatter)
    }

    fun format(localDate: LocalDate): String =  localDate.format(formatter)
}
