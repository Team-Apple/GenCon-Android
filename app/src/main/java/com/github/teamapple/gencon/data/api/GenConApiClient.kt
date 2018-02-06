package com.github.teamapple.gencon.data.api

import com.github.teamapple.gencon.data.api.entity.params.AnnouncementParams
import com.github.teamapple.gencon.data.api.entity.response.AnnouncementResponse
import com.github.teamapple.gencon.data.api.entity.response.EventResponse
import com.github.teamapple.gencon.data.api.entity.response.TaskResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface GenConApiClient {
    @GET("events.json")
    fun getDailyEvents(@Query("start_from_data") startDate: String): Single<List<EventResponse>>

    @GET("tasks.json")
    fun getDailyTasks(@Query("start_from_date") startDate: String): Single<List<TaskResponse>>

    //announcements
    @GET("announcements.json")
    fun getAllAnnouncements(): Single<List<AnnouncementResponse>>

    @PUT("announcements/{id}/")
    fun editAnnouncement(params: AnnouncementParams.EditParams): Single<AnnouncementResponse>

    @POST("announcements")
    fun createAnnouncement(params: AnnouncementParams.CreateParams): Single<AnnouncementResponse>

}
