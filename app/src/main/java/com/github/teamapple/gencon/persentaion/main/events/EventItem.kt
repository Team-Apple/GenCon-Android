package com.github.teamapple.gencon.persentaion.main.events

import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.databinding.ItemEventBinding
import com.github.teamapple.gencon.model.EventModel
import com.xwray.groupie.databinding.BindableItem

class EventItem(private val event: EventModel) : BindableItem<ItemEventBinding>() {

    override fun bind(binding: ItemEventBinding, position: Int) {
        binding.eventName.text = event.name
        binding.startAt.text = event.startAt
        binding.endAt.text = event.endAt
    }


    override fun getLayout(): Int = R.layout.item_event
}
