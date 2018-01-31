package com.github.teamapple.gencon.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.github.teamapple.gencon.data.db.entity.EventEntity
import io.reactivex.Flowable

@Dao
abstract class TaskDao {
    @Query("SELECT * FROM task")
    abstract fun getAllTasks(): Flowable<List<EventEntity>>

    @Query("SELECT * FROM task WHERE task_id = :taskId")
    abstract fun getTaskById(taskId: Int): Flowable<EventEntity>

    @Query("DELETE FROM task")
    abstract fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(tasks: List<EventEntity>)
}
