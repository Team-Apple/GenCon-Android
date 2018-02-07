package com.github.teamapple.gencon.data.datasource.tasks

import com.github.teamapple.gencon.data.api.GenConApiClient
import com.github.teamapple.gencon.data.db.TaskDatabase
import com.github.teamapple.gencon.data.db.entity.mapper.toTaskEntities
import com.github.teamapple.gencon.domain.model.TaskModel
import io.reactivex.Flowable
import javax.inject.Inject


class TasksRemoteDataSource @Inject constructor(
        private val apiClient: GenConApiClient,
        private val database: TaskDatabase
) : TasksDataSource {

    override fun getTasksOfDay(date: String): Flowable<List<TaskModel>> {
        return apiClient.fetchAllTasksOfDay(date)
                .map {  }
    }

}
