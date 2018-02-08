package com.github.teamapple.gencon.data.api.response.mapper

import com.github.teamapple.gencon.data.api.response.AnnouncementResponse
import com.github.teamapple.gencon.model.AnnouncementModel

fun List<AnnouncementResponse>.toAnnouncementModels(): List<AnnouncementModel>
        = map { it.toAnnouncementModel() }

private fun AnnouncementResponse.toAnnouncementModel(): AnnouncementModel =
        AnnouncementModel(id, timing.toAnnouncementTiming(), mode.toAnnouncementMode())

private fun Boolean.toAnnouncementTiming(): AnnouncementModel.TimingModel =
        if (this) {
            AnnouncementModel.TimingModel.MORNING
        } else {
            AnnouncementModel.TimingModel.NIGHT
        }

private fun Int.toAnnouncementMode(): AnnouncementModel.ModeModel =
        when (this) {
            0 -> AnnouncementModel.ModeModel.WEATHER
            1 -> AnnouncementModel.ModeModel.TRASH
            2 -> AnnouncementModel.ModeModel.EXCHANGE
            else -> throw IllegalArgumentException()
        }
