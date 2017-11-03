package com.github.teamapple.gencon.ui.main.events.adapter

import com.github.teamapple.gencon.domain.model.EventModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class EventsRecyclerAdapter : GroupAdapter<ViewHolder>(){
    private val eventsGroup = TasksGroup()
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
