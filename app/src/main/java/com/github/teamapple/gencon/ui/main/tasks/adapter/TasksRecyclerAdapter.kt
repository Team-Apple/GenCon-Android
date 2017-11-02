package com.github.teamapple.gencon.ui.main.tasks.adapter

import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.ui.main.events.adapter.EventsGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class TasksRecyclerAdapter : GroupAdapter<ViewHolder>(){
    private val eventsGroup = EventsGroup()
    init {
        add(eventsGroup)
    }
    fun updateEvents(events: List<EventModel>) {
        eventsGroup.updateGroup(events)
    }

    fun isEmpty():Boolean{
        return eventsGroup.itemCount <= 0
    }
}
