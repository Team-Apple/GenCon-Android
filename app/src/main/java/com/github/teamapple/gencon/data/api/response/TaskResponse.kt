package com.github.teamapple.gencon.data.api.response

import com.squareup.moshi.Json

data class TaskResponse(
        val id: Int,
        val title: String,
        val memo: String?,
        val priority: String,
        @Json(name = "start_from_date")
        val startFromDate: String,
        @Json(name = "start_from_time")
        val startFromTime: String,
        @Json(name = "deadline_date")
        val deadlineDate: String,
        @Json(name = "deadline_time")
        val deadlineTime: String)
