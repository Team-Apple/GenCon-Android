package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.model.EventModel
import io.reactivex.Flowable

interface EventRepository {
    fun getEvents(date: String): Flowable<List<EventModel>>
}
