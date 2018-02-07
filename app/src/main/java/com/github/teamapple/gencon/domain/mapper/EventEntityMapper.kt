package com.github.teamapple.gencon.domain.mapper

import com.github.teamapple.gencon.data.db.entity.EventEntity
import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.domain.model.PriorityModel

private fun EventEntity.toEventModel(): EventModel =
        EventModel(id, title, memo ?: "", startAt, endAt, priority.toPriorityModel())

private fun String.toPriorityModel(): PriorityModel = when (this) {
    "low" -> PriorityModel.Low
    "high" -> PriorityModel.High
    else -> PriorityModel.Normal
}

fun List<EventEntity>.toEventModels(): List<EventModel>
        = map { it.toEventModel() }



