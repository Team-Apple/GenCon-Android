package com.github.teamapple.gencon.data.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "task")
class TaskEntity(
        @PrimaryKey
        var id: Int = 0,
        var title: String,
        var memo: String?,
        var priority: String,
        @ColumnInfo(name = "start_at")
        var startAt: String,
        @ColumnInfo(name = "deadline")
        var deadline: String
)
