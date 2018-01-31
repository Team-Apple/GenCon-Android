package com.github.teamapple.gencon.data.db

import com.github.teamapple.gencon.data.db.entity.TaskEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

interface TaskDatabase {
    fun getAllTasks(): Flowable<List<TaskEntity>>
    fun getEventById(taskId: Int): Maybe<TaskEntity>
    fun save(tasks: List<TaskEntity>)
}
