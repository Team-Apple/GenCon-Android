package com.github.teamapple.gencon.data.mapper

import com.github.teamapple.gencon.data.api.entity.response.EventResponse
import com.github.teamapple.gencon.data.db.entity.EventEntity

private fun EventResponse.toEventEntity(): EventEntity =
        EventEntity(id, title, memo, priority, startAt, endAt)

fun List<EventResponse>.toventEntities(): List<EventEntity>
        = map { it.toEventEntity() }
