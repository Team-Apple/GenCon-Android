package com.github.teamapple.gencon.data.db

import android.arch.persistence.room.RoomDatabase
import com.github.teamapple.gencon.data.db.dao.TaskDao
import com.github.teamapple.gencon.data.db.entity.TaskEntity
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject

class TaskRoomDatabase @Inject constructor(
        private val database: RoomDatabase,
        private val dao: TaskDao
) : TaskDatabase {

    override fun getAllTasks(): Flowable<List<TaskEntity>> = dao.getAllTasks()

    override fun getEventById(taskId: Int): Maybe<TaskEntity> = dao.getTaskById(taskId)

    override fun save(tasks: List<TaskEntity>) {
       database.runInTransaction {
           dao.clearAndInsert(tasks)
       }
    }
}
