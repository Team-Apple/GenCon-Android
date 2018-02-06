package com.github.teamapple.gencon.data.db

import com.github.teamapple.gencon.data.db.dao.TaskDao
import com.github.teamapple.gencon.data.db.entity.TaskEntity
import io.reactivex.Flowable
import io.reactivex.Maybe
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRoomDatabase @Inject constructor(
        private val database: AppDatabase,
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
