package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.db.AnnouncementDatabase
import com.github.teamapple.gencon.data.mapper.toAnnouncementModels
import com.github.teamapple.gencon.model.AnnouncementModel
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnnouncementRepositoryImpl @Inject constructor(
        private val database: AnnouncementDatabase
) : AnnouncementRepository {

    override val announcements: Flowable<List<AnnouncementModel>>
        get() = database.getAllAnnouncements()
                .filter { it.isNotEmpty() }
                .map { it.toAnnouncementModels() }
}
