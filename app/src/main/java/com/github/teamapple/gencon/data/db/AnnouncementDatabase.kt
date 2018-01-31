package com.github.teamapple.gencon.data.db

import com.github.teamapple.gencon.data.db.entity.AnnouncementEntity
import io.reactivex.Flowable

interface AnnouncementDatabase {
    fun getAllAnnouncements(): Flowable<List<AnnouncementEntity>>
    fun save(announcement: List<AnnouncementEntity>)
}
