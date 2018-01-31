package com.github.teamapple.gencon.data.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "task")
class TaskEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        @ColumnInfo(name = "task_id", index = true)
        var taskId: Int,
        var title: String,
        var memo: String?,
        var priority: String,
        @ColumnInfo(name = "start_at")
        var startAt: String,
        @ColumnInfo(name = "deadline")
        var deadline: String
)
