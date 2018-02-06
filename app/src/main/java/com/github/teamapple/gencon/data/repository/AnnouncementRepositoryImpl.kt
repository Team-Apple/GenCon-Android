package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.api.GenConApiClient
import com.github.teamapple.gencon.data.db.AnnouncementDatabase
import com.github.teamapple.gencon.data.mapper.toAnnouncementEntities
import com.github.teamapple.gencon.data.mapper.toAnnouncementModels
import com.github.teamapple.gencon.model.AnnouncementModel
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnnouncementRepositoryImpl @Inject constructor(
        private val apiClient: GenConApiClient,
        private val database: AnnouncementDatabase
) : AnnouncementRepository {

    override val announcements: Flowable<List<AnnouncementModel>>
        get() = database.getAllAnnouncements()
                .filter { it.isNotEmpty() }
                .map { it.toAnnouncementModels() }

    override fun refreshAnnouncements(): Completable =
            apiClient.getAllAnnouncements()
                    .doOnSuccess { database.save(it.toAnnouncementEntities()) }
                    .toCompletable()

}
