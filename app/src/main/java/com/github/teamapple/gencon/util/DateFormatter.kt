package com.github.teamapple.gencon.util

import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

object DateFormatter {
    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    private val outputFormatter = DateTimeFormatter.ofPattern("MM/dd")
    fun format(dateTime: String): String{
        val from = LocalDateTime.parse(dateTime, formatter)
        return outputFormatter.format(from)
    }
}
