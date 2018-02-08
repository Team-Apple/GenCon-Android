package com.github.teamapple.gencon.persentaion.taskDetail

data class NewTaskModel(
        var title: String,
        var memo: String?,
        var startDate:String,
        var startTime: String,
        var endTime: String,
        var endDate: String
)
