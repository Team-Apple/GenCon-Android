package com.github.teamapple.gencon.data.db

import com.github.teamapple.gencon.data.db.entity.EventEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

interface EventDatabase {
    fun getAllEventsOfDay(date: String): Flowable<List<EventEntity>>
    fun getEvent(eventId: Int): Maybe<EventEntity>
    fun save(events: List<EventEntity>)
}
