package com.github.teamapple.gencon.domain.repository

import com.github.teamapple.gencon.data.api.response.EventResponse
import io.reactivex.Single

interface EventRepository {
    fun getEvents(year: Int, month: Int, day: Int): Single<List<EventResponse>>
}
