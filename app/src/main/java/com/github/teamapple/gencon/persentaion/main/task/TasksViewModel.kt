package com.github.teamapple.gencon.persentaion.main.task

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.github.teamapple.gencon.data.api.entity.response.TaskResponse
import com.github.teamapple.gencon.data.repository.TaskRepository
import com.github.teamapple.gencon.util.ext.toLiveData
import javax.inject.Inject

class TasksViewModel @Inject constructor(private val repository: TaskRepository) : ViewModel() {

    val tasks: LiveData<List<TaskResponse>>
        get() = repository.getTasks(2018, 2, 6).toFlowable().toLiveData()

}
