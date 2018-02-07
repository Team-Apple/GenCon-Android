package com.github.teamapple.gencon.data.api.response.mapper

import com.github.teamapple.gencon.data.api.response.TaskResponse
import com.github.teamapple.gencon.data.db.entity.TaskEntity

private fun TaskResponse.toTaskEntity(): TaskEntity =
       TaskEntity(id, title, memo, priority, startAt, deadline)

fun List<TaskResponse>.toTaskEntities(): List<TaskEntity>
        = map { it.toTaskEntity() }
