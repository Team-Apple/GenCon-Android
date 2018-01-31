package com.github.teamapple.gencon.data.api

import com.github.teamapple.gencon.data.api.response.EventResponse
import com.github.teamapple.gencon.data.api.response.TaskResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("events.json")
    fun getDailyEvents(@Query("start_from_data") startDate: String): Single<List<EventResponse>>

    @GET("tasks.json")
    fun getDailyTasks(@Query("start_from_date") startDate: String): Single<List<TaskResponse>>

    @GET("announcements.json")
    fun getAllAnnouncement(): Single<List<TaskResponse>>
}
