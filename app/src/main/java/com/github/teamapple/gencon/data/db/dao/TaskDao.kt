package com.github.teamapple.gencon.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.github.teamapple.gencon.data.db.entity.TaskEntity
import io.reactivex.Flowable
import io.reactivex.Maybe

@Dao
abstract class TaskDao {
    @Query("SELECT * FROM task WHERE start_at > date(:date , '-1 days'")
    abstract fun getAllTasksOfDay(date: String): Flowable<List<TaskEntity>>

    @Query("DELETE FROM task WHRRE start_at > date(:date , '-1 days')")
    abstract fun deleteAllTasksOfDay(date: String)

    @Query("SELECT * FROM task WHERE id = :taskId")
    abstract fun getTask(taskId: Int): Maybe<TaskEntity>

    @Query("DELETE  FROM task WHERE id = :taskId")
    abstract fun deleteTask(taskId: Int)

    @Query("DELETE FROM task")
    abstract fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(tasks: List<TaskEntity>)

}
