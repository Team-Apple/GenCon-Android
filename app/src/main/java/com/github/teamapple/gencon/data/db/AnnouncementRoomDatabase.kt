package com.github.teamapple.gencon.data.db

import android.arch.persistence.room.RoomDatabase
import com.github.teamapple.gencon.data.db.dao.AnnouncementDao
import com.github.teamapple.gencon.data.db.entity.AnnouncementEntity
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnnouncementRoomDatabase @Inject constructor(
        private val database: RoomDatabase,
        private val dao: AnnouncementDao
) : AnnouncementDatabase {

    override fun getAllAnnouncements(): Flowable<List<AnnouncementEntity>> =
            dao.getAllAnnouncements()

    override fun save(announcement: List<AnnouncementEntity>) {
        database.runInTransaction {
            dao.clearAndInsert(announcement)
        }
    }
}
