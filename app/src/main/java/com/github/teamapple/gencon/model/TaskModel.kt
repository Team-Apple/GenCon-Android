package com.github.teamapple.gencon.model

data class TaskModel(val id: Int,
                     val name: String,
                     val memo: String,
                     var startAt: String,
                     var deadline: String,
                     val priority: PriorityModel)
