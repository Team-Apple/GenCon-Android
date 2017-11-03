package com.github.teamapple.gencon.ui.main.tasks.adapter

import com.github.teamapple.gencon.domain.model.TaskModel
import com.xwray.groupie.UpdatingGroup

class TasksGroup :UpdatingGroup() {
    private val items = ArrayList<TaskItem>()


    fun updateGroup(events: List<TaskModel>){
        items.clear()
        items.addAll(events.map { taskModel ->  TaskItem(taskModel) })
        update(items)
    }

}
