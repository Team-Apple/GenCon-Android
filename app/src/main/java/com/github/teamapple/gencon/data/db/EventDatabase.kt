package com.github.teamapple.gencon.data.db

import com.github.teamapple.gencon.data.db.entity.EventEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

interface EventDatabase {
    fun getAllEvents(): Flowable<List<EventEntity>>
    fun getEventById(eventId: Int): Maybe<EventEntity>
    fun save(events: List<EventEntity>)
}
