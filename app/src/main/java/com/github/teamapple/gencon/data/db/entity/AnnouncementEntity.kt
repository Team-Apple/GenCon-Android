package com.github.teamapple.gencon.data.db.entity

import android.arch.persistence.room.Entity

@Entity(tableName = "announcement")
data class AnnouncementEntity(
        var id: Int,
        var timing: Boolean,
        var mode: Int
)
