package com.github.teamapple.gencon.data.db.entity.mapper

import com.github.teamapple.gencon.data.api.response.AnnouncementResponse
import com.github.teamapple.gencon.data.db.entity.AnnouncementEntity

private fun AnnouncementResponse.toAnnouncementEntity(): AnnouncementEntity =
        AnnouncementEntity(id, timing, mode)

fun List<AnnouncementResponse>.toAnnouncementEntities(): List<AnnouncementEntity>
    = map { it.toAnnouncementEntity() }
