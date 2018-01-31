package com.github.teamapple.gencon.data.db

import android.arch.persistence.room.RoomDatabase
import com.github.teamapple.gencon.data.db.dao.EventDao
import com.github.teamapple.gencon.data.db.entity.EventEntity
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject

class EventRoomDatabase @Inject constructor(
        private val database: RoomDatabase,
        private val dao: EventDao
) : EventDatabase {

    override fun getAllEvents(): Flowable<List<EventEntity>> = dao.getAllEvents()

    override fun getEventById(eventId: Int): Maybe<EventEntity> = dao.getEventById(eventId)

    override fun save(events: List<EventEntity>) {
        database.runInTransaction {
            dao.clearAndInsert(events)
        }
    }
}
