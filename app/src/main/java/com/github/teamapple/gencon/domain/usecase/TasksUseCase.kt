package com.github.teamapple.gencon.domain.usecase

import com.github.teamapple.gencon.domain.model.TaskModel
import io.reactivex.Single

interface TasksUseCase {
    fun getTodayEvents(): Single<List<TaskModel>>
}
