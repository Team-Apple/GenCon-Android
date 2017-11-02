package com.github.teamapple.gencon.domain.model

data class TaskModel(val id: Int,
                     val name: String,
                     val priority: PriorityModel,
                     val memo: String) {
}
