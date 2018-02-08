package com.github.teamapple.gencon.model

data class AnnouncementModel(
        val id: Int,
        val timing: TimingModel,
        val mode: ModeModel
){
    enum class TimingModel {
        LEAVE_HOME,
        COME_HOME
    }

    enum class ModeModel {
        WEATHER,
        TRASH,
        EXCHANGE
    }


}
