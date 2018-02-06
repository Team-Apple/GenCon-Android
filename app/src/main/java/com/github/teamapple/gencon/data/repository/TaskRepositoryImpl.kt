package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.api.GenConApiClient
import com.github.teamapple.gencon.data.api.entity.response.TaskResponse
import com.github.teamapple.gencon.data.db.TaskDatabase
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor(
        private val database: TaskDatabase,
        private val apiClient: GenConApiClient): TaskRepository {

    override fun getTasks(year: Int, month: Int, day: Int): Single<List<TaskResponse>> {
        return apiClient.getDailyTasks("$year-$month-$day")
    }

}
