package com.github.teamapple.gencon.data.api.response.mapper

import com.github.teamapple.gencon.data.api.response.EventResponse
import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.domain.model.PriorityModel

private fun EventResponse.toEventModel(): EventModel =
        EventModel(id, title, memo ?: "", startAt.toString(), endAt.toString(), priority.toPriorityModel())

private fun String.toPriorityModel(): PriorityModel = when (this) {
    "low" -> PriorityModel.Low
    "high" -> PriorityModel.High
    else -> PriorityModel.Normal
}

fun List<EventResponse>.toEventModels(): List<EventModel>
        = map { it.toEventModel() }



