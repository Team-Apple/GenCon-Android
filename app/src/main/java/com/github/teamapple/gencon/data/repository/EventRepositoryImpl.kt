package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.api.response.EventResponse
import com.github.teamapple.gencon.domain.repository.EventRepository
import io.reactivex.Single

class EventRepositoryImpl: EventRepository {
    override fun getEvents(year: Int, month: Int, day: Int): Single<List<EventResponse>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
