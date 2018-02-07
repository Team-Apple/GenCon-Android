package com.github.teamapple.gencon.data.mapper

import com.github.teamapple.gencon.data.db.entity.EventEntity
import com.github.teamapple.gencon.model.EventModel
import com.github.teamapple.gencon.model.PriorityModel

private fun EventEntity.toEventModel(): EventModel =
        EventModel(id, title, memo ?: "", startAt, endAt, priority.toPriorityModel())

private fun String.toPriorityModel(): PriorityModel = when (this) {
    "low" -> PriorityModel.Low
    "high" -> PriorityModel.High
    else -> PriorityModel.Normal
}

fun List<EventEntity>.toEventModels(): List<EventModel>
        = map { it.toEventModel() }



