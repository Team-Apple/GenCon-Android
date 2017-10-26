package com.github.team_apple.gencon.presentation.ui.main.events

import com.github.team_apple.gencon.domain.model.EventModel
import com.github.team_apple.gencon.presentation.ui.main.events.item.EventsGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class EventsRecyclerAdapter :GroupAdapter<ViewHolder>() {
    private val eventsGroup = EventsGroup()

    fun updateEvents(events:List<EventModel>){
        eventsGroup.updateGroup(events)
    }
}
