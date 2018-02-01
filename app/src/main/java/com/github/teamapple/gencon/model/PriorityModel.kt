package com.github.teamapple.gencon.model

enum class PriorityModel {
    Low,
    Normal,
    High;

    companion object {
        internal fun from(priority: String): PriorityModel {
            return when (priority) {
                "low" -> Low
                "high" -> High
                else -> Normal
            }
        }
    }
}
