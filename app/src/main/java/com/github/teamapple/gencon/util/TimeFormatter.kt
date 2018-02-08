package com.github.teamapple.gencon.util

import org.threeten.bp.LocalTime
import org.threeten.bp.format.DateTimeFormatter


object TimeFormatter {
    private val formatter = DateTimeFormatter.ofPattern("hh:mm")

    fun format(hour:Int,minute: Int): String{
       return LocalTime.of(hour,minute).format(formatter)
    }

    fun format(localTime: LocalTime) : String = localTime.format(formatter)
}
