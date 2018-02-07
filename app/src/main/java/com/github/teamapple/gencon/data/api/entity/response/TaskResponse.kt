package com.github.teamapple.gencon.data.api.entity.response

import com.squareup.moshi.Json

data class TaskResponse(
        val id: Int,
        val title: String,
        val memo: String?,
        val priority: String,
        @Json(name = "start_from")
        val startAt: String,
        @Json(name = "deadline")
        val deadline: String)
