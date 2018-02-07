package com.github.teamapple.gencon.data.db

import com.github.teamapple.gencon.data.db.dao.EventDao
import com.github.teamapple.gencon.data.db.entity.EventEntity
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRoomDatabase @Inject constructor(
        private val database: AppDatabase,
        private val dao: EventDao
) : EventDatabase {

    override fun getAllEventsOfDay(date: String): Flowable<List<EventEntity>> = dao.getAllEventsOfDay(date)

    override fun getEvent(eventId: Int): Maybe<EventEntity> = dao.getEvent(eventId)

    override fun save(events: List<EventEntity>) {
        database.runInTransaction {
            dao.clearAndInsert(events)
        }
    }
}
