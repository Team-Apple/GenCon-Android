package com.github.team_apple.gencon.presentation.ui.main.events.item

import com.github.team_apple.gencon.R
import com.github.team_apple.gencon.domain.model.EventModel
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.row_events_event.view.*

class EventItem(val event: EventModel) : Item<ViewHolder>() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        with(viewHolder.itemView) {
            eventName.text = event.name
            startTime.text = event.startTime
            endTime.text = event.endTime
        }
    }

    override fun getLayout(): Int = R.layout.row_events_event
}
