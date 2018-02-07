package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.api.GenConApiClient
import com.github.teamapple.gencon.data.db.TaskDatabase
import com.github.teamapple.gencon.data.db.entity.TaskEntity
import com.github.teamapple.gencon.domain.repository.TaskRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor(
        private val database: TaskDatabase,
        private val apiClient: GenConApiClient): TaskRepository {

    override fun getAllTasksOfDay(date: String): Flowable<List<TaskEntity>> {
        return database.getAllTasksOfDay(date)
    }

}
