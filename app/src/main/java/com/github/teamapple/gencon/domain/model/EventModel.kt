package com.github.teamapple.gencon.domain.model

import com.github.teamapple.gencon.data.entity.response.EventResponse

data class EventModel(val id: Int,
                      val name: String,
                      val memo: String,
                      val startTime: String,
                      val endTime: String,
                      val priority: PriorityModel
){
    companion object {
        fun convert(response: EventResponse,formatter: DateFormatter):EventModel{
            return EventModel(
                    id = response.id,
                    name = response.title,
                    memo = response.memo?:"",
                    startTime = formatter.format(response.startAt),
                    endTime = formatter.format(response.endAt),
                    priority = PriorityModel.from(response.priority)
                    )
        }
    }
}
