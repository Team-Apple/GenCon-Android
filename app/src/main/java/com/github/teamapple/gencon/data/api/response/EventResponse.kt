package com.github.teamapple.gencon.data.api.response

import com.squareup.moshi.Json
import org.threeten.bp.LocalDateTime

data class EventResponse(
        val id: Int,
        val title: String,
        val memo: String?,
        val priority: String,
        @Json(name = "start_at")
        val startAt: LocalDateTime,
        @Json(name = "end_at")
        val endAt: LocalDateTime)
