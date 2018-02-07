package com.github.teamapple.gencon.data.db.dao

import android.arch.persistence.room.*
import com.github.teamapple.gencon.data.db.entity.EventEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
abstract class EventDao {
    @Query("SELECT * FROM event WHERE start_at BETWEEN :date || ' 00:00:00' AND :date || ' 23:59:59'")
    abstract fun getAllEventsOfDay(date: String): Flowable<List<EventEntity>>

    @Query("SELECT * FROM event WHERE id = :eventId")
    abstract fun getEvent(eventId: Int): Maybe<EventEntity>

    @Query("DELETE FROM event")
    abstract fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(events: List<EventEntity>)

    @Transaction
    open fun clearAndInsert(events: List<EventEntity>){
        deleteAll()
        insert(events)
    }
}
