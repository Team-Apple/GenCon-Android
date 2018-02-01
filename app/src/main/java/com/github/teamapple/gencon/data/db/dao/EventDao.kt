package com.github.teamapple.gencon.data.db.dao

import android.arch.persistence.room.*
import com.github.teamapple.gencon.data.db.entity.EventEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
abstract class EventDao {
    @Query("SELECT * FROM event")
    abstract fun getAllEvents(): Flowable<List<EventEntity>>

    @Query("SELECT * FROM event WHERE id = :eventId")
    abstract fun getEventById(eventId: Int): Maybe<EventEntity>

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
