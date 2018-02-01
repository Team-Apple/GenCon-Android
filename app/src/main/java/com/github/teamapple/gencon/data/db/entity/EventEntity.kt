package com.github.teamapple.gencon.data.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity

@Entity(tableName = "event")
data class EventEntity(
        var id: Int,
        var title: String,
        var memo: String?,
        var priority: String,
        @ColumnInfo(name = "start_at")
        var startAt: String,
        @ColumnInfo(name = "end_at")
        var endAt: String)
