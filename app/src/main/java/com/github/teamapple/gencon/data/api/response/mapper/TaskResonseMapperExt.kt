package com.github.teamapple.gencon.data.api.response.mapper

import com.github.teamapple.gencon.data.api.response.TaskResponse
import com.github.teamapple.gencon.domain.model.PriorityModel
import com.github.teamapple.gencon.domain.model.TaskModel

private fun TaskResponse.toTaskModel(): TaskModel =
        TaskModel(id, title, memo ?: "", startAt, deadline, priority.toPriorityModel())

private fun String.toPriorityModel(): PriorityModel = when (this) {
    "low" -> PriorityModel.Low
    "high" -> PriorityModel.High
    else -> PriorityModel.Normal
}

fun List<TaskResponse>.toTaskModels(): List<TaskModel>
        = map { it.toTaskModel() }
