package com.github.team_apple.gencon.domain.model

enum class PriorityModel {
    Low,
    Normal,
    High;

    fun from(priority: Int): PriorityModel {
        return values().filter { it.ordinal == priority }.firstOrNull() ?: Normal
    }
}
