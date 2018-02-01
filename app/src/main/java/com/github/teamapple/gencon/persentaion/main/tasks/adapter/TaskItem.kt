package com.github.teamapple.gencon.persentaion.main.tasks.adapter

import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.model.TaskModel
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.item_events_event.view.*

class TaskItem(private val event: TaskModel) : Item<ViewHolder>() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        with(viewHolder.itemView) {
            eventName.text = event.name
            /*startTime.text = context.getString(R.string.start_time, event.startTime)
            endTime.text = context.getString(R.string.end_time, event.endTime)*/
        }
    }

    override fun getLayout(): Int = R.layout.item_events_event
}
