package com.github.teamapple.gencon.domain.repository

import com.github.teamapple.gencon.data.entity.response.EventResponse
import com.github.teamapple.gencon.domain.model.DateModel
import io.reactivex.Single

interface EventsRepository {
    fun fetchDailyEvents(date: DateModel): Single<List<EventResponse>>
}
