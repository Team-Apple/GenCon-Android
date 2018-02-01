package com.github.teamapple.gencon.ui.main.tasks.adapter

import com.github.teamapple.gencon.model.TaskModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class TasksRecyclerAdapter : GroupAdapter<ViewHolder>(){
    private val eventsGroup = TasksGroup()
    init {
        add(eventsGroup)
    }
    fun updateTasks(tasks: List<TaskModel>) {
        eventsGroup.updateGroup(tasks)
    }

    fun isEmpty():Boolean{
        return eventsGroup.itemCount <= 0
    }
}
