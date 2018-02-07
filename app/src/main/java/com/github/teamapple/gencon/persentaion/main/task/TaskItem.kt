package com.github.teamapple.gencon.persentaion.main.task

import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.databinding.ItemTaskBinding
import com.github.teamapple.gencon.domain.model.TaskModel
import com.xwray.groupie.databinding.BindableItem

class TaskItem(private val taak: TaskModel) : BindableItem<ItemTaskBinding>() {

    override fun bind(binding: ItemTaskBinding, position: Int) {
        /*binding.taskName.text = taak.name
        binding.startAt.text = taak.startAt
        binding.deadline.text = taak*/
    }


    override fun getLayout(): Int = R.layout.item_event
}
