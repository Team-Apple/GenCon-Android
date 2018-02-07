package com.github.teamapple.gencon.util.ext

import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId

fun LocalDateTime.toUTC():LocalDateTime =
    atZone(ZoneId.of("Asia/Tokyo")).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime()

fun LocalDateTime.toJst():LocalDateTime =
        atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Tokyo")).toLocalDateTime()
