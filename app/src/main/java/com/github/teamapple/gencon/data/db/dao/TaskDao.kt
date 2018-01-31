package com.github.teamapple.gencon.data.db.dao

import android.arch.persistence.room.*
import com.github.teamapple.gencon.data.db.entity.TaskEntity
import io.reactivex.Flowable

@Dao
abstract class TaskDao {
    @Query("SELECT * FROM task")
    abstract fun getAllTasks(): Flowable<List<TaskEntity>>

    @Query("SELECT * FROM task WHERE task_id = :taskId")
    abstract fun getTaskById(taskId: Int): Flowable<TaskEntity>

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
