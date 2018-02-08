package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.api.GenConApiClient
import com.github.teamapple.gencon.data.api.response.mapper.toEventModels
import com.github.teamapple.gencon.model.EventModel
import io.reactivex.Flowable
import javax.inject.Inject

class EventRepositoryImpl@Inject constructor(private val apiClient: GenConApiClient): EventRepository {

    override fun getEvents(date: String): Flowable<List<EventModel>> {
        return apiClient.fetchAllEventsOfDay(date)
                .map { it.toEventModels() }
    }

}
