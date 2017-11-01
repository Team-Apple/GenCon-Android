package com.github.teamapple.gencon.domain.usecase

import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.model.EventModel
import io.reactivex.Single

interface EventsUseCase {
    fun getDailyEvents(date: DateModel): Single<List<EventModel>>
    fun getTodayEvents(): Single<List<EventModel>>
}
