package com.github.teamapple.gencon.data.db.entity.mapper

import android.arch.persistence.room.TypeConverter
import com.github.teamapple.gencon.util.ext.toJst
import com.github.teamapple.gencon.util.ext.toUTC
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

class LocalDateTimeConverter {
    companion object {
        private val FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    }

    @TypeConverter
    fun fromTimestamp(value: String?): LocalDateTime? {
        if (value == null) {
            return null
        }
        return LocalDateTime.parse(value, FORMATTER).toJst()
    }


    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): String? =
            date?.toUTC()?.toString()
}
