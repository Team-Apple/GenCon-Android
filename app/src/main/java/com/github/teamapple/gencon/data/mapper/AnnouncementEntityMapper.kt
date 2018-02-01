package com.github.teamapple.gencon.data.mapper

import com.github.teamapple.gencon.data.db.entity.AnnouncementEntity
import com.github.teamapple.gencon.model.AnnouncementModel


fun List<AnnouncementEntity>.toAnnouncementModels(): List<AnnouncementModel> =
        map { it.toAnnouncementModel() }

private fun AnnouncementEntity.toAnnouncementModel(): AnnouncementModel =
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
