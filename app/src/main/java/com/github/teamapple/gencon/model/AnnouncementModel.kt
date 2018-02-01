package com.github.teamapple.gencon.model

data class AnnouncementModel(
        val timing: TimingModel,
        val mode: Int
){
    enum class TimingModel {
        MORNING,
        NIGHT
    }

}
