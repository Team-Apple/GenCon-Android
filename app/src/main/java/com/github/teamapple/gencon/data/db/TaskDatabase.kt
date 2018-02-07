package com.github.teamapple.gencon.data.db

import com.github.teamapple.gencon.data.db.entity.TaskEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

interface TaskDatabase {
    fun getAllTasksOfDay(date: String): Flowable<List<TaskEntity>>
    fun deleteAllTaskOfDay(date: String)
    fun getEvent(taskId: Int): Maybe<TaskEntity>
    fun deleteTask(taskId: Int)
    fun save(date: String, tasks: List<TaskEntity>)
}
