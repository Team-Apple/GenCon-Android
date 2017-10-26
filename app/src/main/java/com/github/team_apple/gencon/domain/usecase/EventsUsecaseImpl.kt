package com.github.team_apple.gencon.domain.usecase

import com.github.team_apple.gencon.domain.model.DateModel
import com.github.team_apple.gencon.domain.model.EventModel
import com.github.team_apple.gencon.domain.model.PriorityModel
import io.reactivex.Single

class EventsUsecaseImpl : EventsUsecase {

    override fun getDailyEvents(date: DateModel): Single<List<EventModel>> {
        val event = EventModel(id = 0, name = "ほげ", memo = "", startTime = "2017/10/26", endTime = "2017/10/26", priority = PriorityModel.Normal)
        return Single.just(0.until(10).map { event.copy() })
    }
}
