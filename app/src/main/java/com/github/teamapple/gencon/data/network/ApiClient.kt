package com.github.teamapple.gencon.data.network

import com.github.teamapple.gencon.data.entity.params.EventCreateParams
import com.github.teamapple.gencon.data.entity.response.EventResponse
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiClient{
    @GET("events.json")
    fun fetchDailyEvents(@Query("start_at_date") startDate:String): Single<List<EventResponse>>

    @POST("events")
    fun createEvent(@Body event:EventCreateParams):Completable
}
