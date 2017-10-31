package com.github.teamapple.gencon.domain.model

data class EventModel(val id: Long,
                      val name: String,
                      val memo: String,
                      val startTime: String,
                      val endTime: String,
                      val priority: PriorityModel
)
