package com.github.teamapple.gencon.persentaion.main.task

import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.databinding.ItemTaskBinding
import com.github.teamapple.gencon.model.TaskModel
import com.xwray.groupie.databinding.BindableItem

class TaskItem(private val task: TaskModel) : BindableItem<ItemTaskBinding>() {

    override fun bind(binding: ItemTaskBinding, position: Int) {
        binding.taskName.text = task.name
        binding.startAt.text = task.startAt
        binding.deadline.text = task.deadline
    }

    override fun getLayout(): Int = R.layout.item_task
}
