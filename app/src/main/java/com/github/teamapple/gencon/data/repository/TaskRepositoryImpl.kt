package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.api.GenConApiClient
import com.github.teamapple.gencon.data.api.response.mapper.toTaskModels
import com.github.teamapple.gencon.model.TaskModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.processors.BehaviorProcessor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryImpl @Inject constructor(
        private val apiClient: GenConApiClient): TaskRepository {
    private val prosesser = BehaviorProcessor.create<List<TaskModel>>()
    override fun getAllTasksOfDay(date: String): Flowable<List<TaskModel>> {
        return prosesser
    }

    override fun refreshTasks(date: String): Completable {
        return apiClient.fetchAllTasksOfDay(date)
                .map { it.toTaskModels() }
                .doOnSuccess { prosesser.onNext(it) }
                .toCompletable()
    }

}
