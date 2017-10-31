package com.github.teamapple.gencon.presentation.ui.main.events.item

import com.github.teamapple.gencon.domain.model.EventModel
import com.xwray.groupie.UpdatingGroup

class EventsGroup :UpdatingGroup() {
    private val items = ArrayList<EventItem>()


    fun updateGroup(events: List<EventModel>){
        items.addAll(events.map {eventModel ->  EventItem(eventModel) })
        update(items)
    }

}
