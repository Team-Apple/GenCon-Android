package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.api.entity.response.EventResponse
import io.reactivex.Single

interface TaskRepository {
    fun getEvents(year: Int, month: Int, day: Int): Single<List<EventResponse>>
}
