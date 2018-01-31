package com.github.teamapple.gencon.data.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class EventEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        @ColumnInfo(name = "event_id", index = true)
        var eventId: Int,
        var title: String,
        var memo: String?,
        var priority: String,
        @ColumnInfo(name = "start_at")
        var startAt: String,
        @ColumnInfo(name = "end_at")
        var endAt: String,
        @ColumnInfo(name = "created_at")
        var createdAt: String,
        @ColumnInfo(name = "updated_at")
        var updatedAt: String
)
