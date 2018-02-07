package com.github.teamapple.gencon.domain.model

data class AnnouncementModel(
        val id: Int,
        val timing: TimingModel,
        val mode: ModeModel
){
    enum class TimingModel {
        MORNING,
        NIGHT
    }

    enum class ModeModel {
        WEATHER,
        TRASH,
        EXCHANGE
    }


}
