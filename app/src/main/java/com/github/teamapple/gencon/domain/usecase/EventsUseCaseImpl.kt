package com.github.teamapple.gencon.domain.usecase

import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.domain.model.PriorityModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EventsUseCaseImpl @Inject constructor(): EventsUseCase {

    override fun getDailyEvents(date: DateModel): Single<List<EventModel>> {
        val event = EventModel(id = 0, name = "hoge", memo = "", startTime = "10:20", endTime = "10:30", priority = PriorityModel.Normal)
        return Single.just(0.until(20).map { event.copy() }).subscribeOn(Schedulers.io())
    }
}
