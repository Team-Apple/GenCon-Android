package com.github.teamapple.gencon.ui.main.events.adapter

import com.github.teamapple.gencon.model.EventModel
import com.xwray.groupie.UpdatingGroup

class EventsGroup :UpdatingGroup() {
    private val items = ArrayList<EventItem>()


    fun updateGroup(events: List<EventModel>){
        items.clear()
        items.addAll(events.map {eventModel -> EventItem(eventModel) })
        update(items)
    }

}
