package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.domain.model.AnnouncementModel
import io.reactivex.Completable
import io.reactivex.Flowable

interface AnnouncementRepository {
    val announcements: Flowable<List<AnnouncementModel>>

    fun refreshAnnouncements(): Completable

}
