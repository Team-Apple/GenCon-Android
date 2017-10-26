package com.github.team_apple.gencon.domain.model

data class EventModel(val id: Long,
                      val name: String,
                      val memo: String,
                      val startTime: String,
                      val endTime: String,
                      val priority: PriorityModel
)
