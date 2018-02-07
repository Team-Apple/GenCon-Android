package com.github.teamapple.gencon.data.datasource.tasks

import com.github.teamapple.gencon.domain.model.TaskModel
import io.reactivex.Flowable

interface TasksDataSource {

    fun getTasksOfDay(date: String): Flowable<List<TaskModel>>

}
