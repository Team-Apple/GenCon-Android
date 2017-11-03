package com.github.teamapple.gencon.domain.usecase

import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.model.TaskModel
import io.reactivex.Single

interface TasksUseCase {
    fun getDaysEvents(date:DateModel): Single<List<TaskModel>>
}
