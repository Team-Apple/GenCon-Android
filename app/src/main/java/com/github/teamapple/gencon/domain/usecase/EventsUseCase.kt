package com.github.teamapple.gencon.domain.usecase

import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.model.EventModel
import io.reactivex.Completable
import io.reactivex.Single

interface EventsUseCase {
    fun getEventsOfDay(date: DateModel): Single<List<EventModel>>
    fun createEvent(newEvent: EventModel):Completable
    fun editEvent(eventId:Int, editedEvent:EventModel): Completable
    fun deleteEvent(eventId:Int): Completable
}
