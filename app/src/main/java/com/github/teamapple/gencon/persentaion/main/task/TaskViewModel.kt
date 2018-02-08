package com.github.teamapple.gencon.persentaion.main.task

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.github.teamapple.gencon.data.repository.TaskRepository
import com.github.teamapple.gencon.model.TaskModel
import com.github.teamapple.gencon.util.DateFormatter
import com.github.teamapple.gencon.util.ext.toLiveData
import org.threeten.bp.LocalDate
import javax.inject.Inject

class TaskViewModel @Inject constructor(repository: TaskRepository) : ViewModel() {

    val allTasksOfDay: LiveData<List<TaskModel>> =
            repository.getAllTasksOfDay(DateFormatter.format(LocalDate.now()))
                    .toLiveData()

}
