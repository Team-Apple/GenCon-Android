package com.github.teamapple.gencon.model

data class AnnounceModel(
        val timing: AnnounceTimingModel,
        val mode: Int
)

enum class AnnounceTimingModel {
    MORNING,
    NIGHT
}
