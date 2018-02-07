package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.api.GenConApiClient
import com.github.teamapple.gencon.data.api.response.mapper.toAnnouncementModels
import com.github.teamapple.gencon.domain.model.AnnouncementModel
import com.github.teamapple.gencon.domain.repository.AnnouncementRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnnouncementRepositoryImpl @Inject constructor(
        private val apiClient: GenConApiClient
) : AnnouncementRepository {
    override fun refreshAnnouncements(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val announcements: Flowable<List<AnnouncementModel>>
        get() = apiClient.fetchAllAnnouncements()
                .filter { it.isNotEmpty() }
                .map { it.toAnnouncementModels() }

}
