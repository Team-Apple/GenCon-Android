package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.entity.response.EventResponse
import com.github.teamapple.gencon.data.network.ApiClient
import com.github.teamapple.gencon.domain.model.EventModel
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(private val client: ApiClient) : EventsRepository {
    override fun createEvent(newEvent: EventModel): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun editEvent(eventId: Int, editedEvent: EventModel): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteEvent(eventId: Int): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEvents(year: Int, month: Int, day: Int): Single<List<EventResponse>> {
        return client.fetchDailyEvents("$year-$month-$day}")
    }

}
