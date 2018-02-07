package com.github.teamapple.gencon.domain.mapper

import com.github.teamapple.gencon.data.db.entity.TaskEntity
import com.github.teamapple.gencon.domain.model.PriorityModel
import com.github.teamapple.gencon.domain.model.TaskModel

private fun TaskEntity.toTaskModel(): TaskModel =
        TaskModel(id, title, memo ?: "", startAt, deadline, priority.toPriorityModel())

private fun String.toPriorityModel(): PriorityModel = when (this) {
    "low" -> PriorityModel.Low
    "high" -> PriorityModel.High
    else -> PriorityModel.Normal
}

fun List<TaskEntity>.toTaskModels(): List<TaskModel>
        = map { it.toTaskModel() }
