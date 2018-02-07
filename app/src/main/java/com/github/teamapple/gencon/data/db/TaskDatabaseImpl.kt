package com.github.teamapple.gencon.data.db

import com.github.teamapple.gencon.data.db.dao.TaskDao
import com.github.teamapple.gencon.data.db.entity.TaskEntity
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskDatabaseImpl @Inject constructor(
        private val database: AppDatabase,
        private val dao: TaskDao
) : TaskDatabase {
    override fun getAllTasksOfDay(date: String): Flowable<List<TaskEntity>> = dao.getAllTasksOfDay(date)

    override fun deleteAllTaskOfDay(date: String) {
        dao.deleteAllTasksOfDay(date)
    }

    override fun getEvent(taskId: Int): Maybe<TaskEntity> = dao.getTask(taskId)

    override fun deleteTask(taskId: Int) {
        dao.deleteTask(taskId)
    }

    override fun save(date: String, tasks: List<TaskEntity>) {
        database.runInTransaction {
            dao.deleteAllTasksOfDay(date)
            dao.insert(tasks)
        }
    }
}
