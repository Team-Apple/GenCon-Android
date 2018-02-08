package com.github.teamapple.gencon.persentaion.main.task

import android.arch.lifecycle.ViewModel
import com.github.teamapple.gencon.data.repository.TaskRepository
import com.github.teamapple.gencon.util.ext.toLiveData
import javax.inject.Inject

class TaskViewModel @Inject constructor(private val repository: TaskRepository) : ViewModel() {

    fun getAllTasksOfDay() =
            repository.getAllTasksOfDay("2018-02-08")
                    .toLiveData()

}
