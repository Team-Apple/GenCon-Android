package com.github.teamapple.gencon.domain.model

enum class PriorityModel {
    Low,
    Normal,
    High;

    companion object {
        fun from(priority: String): PriorityModel {
            return when (priority) {
                "low" -> Low
                "high" -> High
                else -> Normal
            }
        }
    }
}
