package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.db.entity.TaskEntity
import io.reactivex.Flowable

interface TaskRepository {
    fun getAllTasksOfDay(date: String): Flowable<List<TaskEntity>>
}
