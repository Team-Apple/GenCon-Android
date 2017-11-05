package com.github.teamapple.gencon.data.entity.params

import com.squareup.moshi.Json

data class EventCreateParams(
    val title:String,
    val memo:String,
    @Json(name = "start_at_date")
    val startDate:String,
    @Json(name = "start_at_time")
    val statTime:String,
    @Json(name = "end_at_date")
    val endDate:String,
    @Json(name = "end_at_time")
    val endTime:String,
    val priority:String

)
