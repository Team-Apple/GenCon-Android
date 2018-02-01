package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.api.response.EventResponse
import io.reactivex.Single

interface AnnouncementRepository {
    fun getEvents(year: Int, month: Int, day: Int): Single<List<EventResponse>>
}
