package com.github.teamapple.gencon.persentaion.main.tasks.adapter

import com.github.teamapple.gencon.model.TaskModel
import com.xwray.groupie.UpdatingGroup

class TasksGroup :UpdatingGroup() {
    private val items = ArrayList<TaskItem>()


    fun updateGroup(events: List<TaskModel>){
        items.clear()
        items.addAll(events.map { taskModel ->  TaskItem(taskModel) })
        update(items)
    }

}
