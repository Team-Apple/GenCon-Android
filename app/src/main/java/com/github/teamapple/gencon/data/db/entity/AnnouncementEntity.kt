package com.github.teamapple.gencon.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "announcement")
data class AnnouncementEntity(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var timing: Boolean,
        var mode: Int
)
