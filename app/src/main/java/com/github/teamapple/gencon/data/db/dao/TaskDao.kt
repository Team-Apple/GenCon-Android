package com.github.teamapple.gencon.data.db.dao

import android.arch.persistence.room.*
import com.github.teamapple.gencon.data.db.entity.TaskEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
abstract class TaskDao {
    @Query("SELECT * FROM task WHERE start_at BETWEEN :date || ' 00:00:00' AND :date || ' 23:59:59'")
    abstract fun getAllTasksOfDay(): Flowable<List<TaskEntity>>

    @Query("SELECT * FROM task WHERE id = :taskId")
    abstract fun getTask(taskId: Int): Maybe<TaskEntity>

    @Query("DELETE FROM task")
    abstract fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(tasks: List<TaskEntity>)

    @Transaction
    open fun clearAndInsert(tasks: List<TaskEntity>){
        deleteAll()
        insert(tasks)
    }
}
