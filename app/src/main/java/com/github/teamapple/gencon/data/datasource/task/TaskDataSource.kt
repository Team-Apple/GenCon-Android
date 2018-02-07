package com.github.teamapple.gencon.data.datasource.task

import com.github.teamapple.gencon.domain.model.TaskModel
import io.reactivex.Flowable

interface TaskDataSource {

    fun getTasksOfDay(dateString: String): Flowable<List<TaskModel>>
}
