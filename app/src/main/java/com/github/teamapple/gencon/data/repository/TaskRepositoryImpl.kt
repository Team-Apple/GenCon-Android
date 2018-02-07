package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.api.GenConApiClient
import com.github.teamapple.gencon.data.api.response.mapper.toTaskModels
import com.github.teamapple.gencon.domain.model.TaskModel
import com.github.teamapple.gencon.domain.repository.TaskRepository
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor(
        private val apiClient: GenConApiClient): TaskRepository {

    override fun getAllTasksOfDay(date: String): Flowable<List<TaskModel>> {
        return apiClient.fetchAllTasksOfDay(date)
                .map { it.toTaskModels() }
    }

}
