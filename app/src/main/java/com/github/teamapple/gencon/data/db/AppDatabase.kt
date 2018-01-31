package com.github.teamapple.gencon.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.github.teamapple.gencon.data.db.dao.AnnouncementDao
import com.github.teamapple.gencon.data.db.dao.EventDao
import com.github.teamapple.gencon.data.db.dao.TaskDao
import com.github.teamapple.gencon.data.db.entity.AnnouncementEntity
import com.github.teamapple.gencon.data.db.entity.EventEntity
import com.github.teamapple.gencon.data.db.entity.TaskEntity

@Database(
        entities = [
            (AnnouncementEntity::class),
            (EventEntity::class),
            (TaskEntity::class)
        ],
        version = 1
)
abstract class AppDatabase: RoomDatabase(){
    abstract fun announcementDao(): AnnouncementDao
    abstract fun eventDao(): EventDao
    abstract fun taskDao(): TaskDao
}
