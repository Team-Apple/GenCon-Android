package com.github.teamapple.gencon.domain.usecase

import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.model.PriorityModel
import com.github.teamapple.gencon.domain.model.TaskModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TasksUseCaseImpl @Inject constructor() : TasksUseCase {

    override fun getEvents(date:DateModel): Single<List<TaskModel>> {
        val event = TaskModel(id = 0, name = "hoge", memo = "", priority = PriorityModel.Normal)
        return Single.just(0.until(20).map { event.copy() }).subscribeOn(Schedulers.io())
    }

}
