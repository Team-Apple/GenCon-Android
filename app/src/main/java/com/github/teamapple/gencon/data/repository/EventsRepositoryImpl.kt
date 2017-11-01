package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.entity.response.EventResponse
import com.github.teamapple.gencon.data.network.ApiClient
import com.github.teamapple.gencon.domain.model.DateModel
import com.github.teamapple.gencon.domain.repository.EventsRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventsRepositoryImpl @Inject constructor(private val client: ApiClient) : EventsRepository {
    override fun fetchDailyEvents(date: DateModel): Single<List<EventResponse>> {
        return client.fetchDailyEvents(formatDate(date))
    }


    private fun formatDate(date: DateModel) = "${date.year}-${date.month}-${date.day}"
}
