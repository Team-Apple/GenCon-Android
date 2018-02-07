package com.github.teamapple.gencon.domain.repository

import com.github.teamapple.gencon.domain.model.TaskModel
import io.reactivex.Flowable

interface TaskRepository {
    fun getAllTasksOfDay(date: String): Flowable<List<TaskModel>>
}
