package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.model.AnnouncementModel
import io.reactivex.Flowable

interface AnnouncementRepository {
    val announcements: Flowable<List<AnnouncementModel>>


}
