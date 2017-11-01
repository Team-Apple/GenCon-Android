package com.github.teamapple.gencon.presentation.ui.main.events

import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.presentation.ui.main.events.item.EventsGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class EventsRecyclerAdapter : GroupAdapter<ViewHolder>(){
    private val eventsGroup = EventsGroup()

    fun updateEvents(events: List<EventModel>) {
        eventsGroup.updateGroup(events)
    }

    fun isEmpty():Boolean{
        return eventsGroup.itemCount <= 0
    }
}
