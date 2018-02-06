package com.github.teamapple.gencon.data.repository

import com.github.teamapple.gencon.data.api.entity.response.TaskResponse
import io.reactivex.Single

interface TaskRepository {
    fun getTasks(year: Int, month: Int, day: Int): Single<List<TaskResponse>>
}
