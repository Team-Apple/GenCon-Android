package com.github.teamapple.gencon.data.api.params

import com.squareup.moshi.Json

class TaskParams{

    class CreateParams(
            val title: String,
            val memo: String?,
            val priority: String,
            @Json(name="start_from_date")
            val startFromDate:String,
            @Json(name = "start_from_time")
            val startFromTime: String,
            @Json(name = "deadline_date")
            val deadlineDate: String,
            @Json(name = "deadline_time")
            val deadlineTime: String
    )
}
