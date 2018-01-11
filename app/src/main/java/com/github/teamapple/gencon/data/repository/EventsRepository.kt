package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.entity.response.EventResponse
import com.github.teamapple.gencon.domain.model.EventModel
import io.reactivex.Completable
import io.reactivex.Single

interface EventsRepository {
    fun getEvents(year: Int, month: Int, day: Int): Single<List<EventResponse>>
    fun createEvent(newEvent: EventModel): Completable
    fun editEvent(eventId: Int, editedEvent: EventModel): Completable
    fun deleteEvent(eventId: Int): Completable
}
