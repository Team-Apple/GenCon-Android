package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.model.TaskModel
import io.reactivex.Flowable

interface TaskRepository {
    fun getAllTasksOfDay(date: String): Flowable<List<TaskModel>>
}
