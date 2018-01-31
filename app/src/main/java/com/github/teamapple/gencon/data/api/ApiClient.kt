package com.github.teamapple.gencon.data.api

import com.github.teamapple.gencon.data.api.response.EventResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient{
    @GET("events.json")
    fun fetchDailyEvents(@Query("start_at_date") startDate:String): Single<List<EventResponse>>
}
