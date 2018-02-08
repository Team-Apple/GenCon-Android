package com.github.teamapple.gencon.persentaion.main.announcement

import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.databinding.ItemAnnouncementBinding
import com.github.teamapple.gencon.model.AnnouncementModel
import com.xwray.groupie.databinding.BindableItem

class AnnouncementItem(private val announcementModel: AnnouncementModel) : BindableItem<ItemAnnouncementBinding>() {

    override fun bind(binding: ItemAnnouncementBinding, position: Int) {
        val context = binding.root.context
        binding.icon.setCircleBackgroundColorResource(announcementModel.mode.toColorRes())
        binding.icon.setImageDrawable(context.getDrawable(announcementModel.mode.toDrawableRes()))
        binding.timing.text = context.getString(announcementModel.timing.toStringRes())
        binding.mode.text = context.getString(announcementModel.mode.toStringRes())
    }

    override fun getLayout(): Int = R.layout.item_announcement


    @StringRes
    private fun AnnouncementModel.TimingModel.toStringRes(): Int =
            when (this) {
                AnnouncementModel.TimingModel.LEAVE_HOME -> R.string.announce_timing_leave_home
                AnnouncementModel.TimingModel.COME_HOME -> R.string.announce_timing_come_home
            }

    @StringRes
    private fun AnnouncementModel.ModeModel.toStringRes(): Int =
            when (this) {
                AnnouncementModel.ModeModel.EXCHANGE -> R.string.announce_mode_exchange
                AnnouncementModel.ModeModel.TRASH -> R.string.announce_mode_trash
                AnnouncementModel.ModeModel.WEATHER -> R.string.announce_mode_weather
            }

    @DrawableRes
    private fun AnnouncementModel.ModeModel.toDrawableRes(): Int =
            when (this) {
                AnnouncementModel.ModeModel.EXCHANGE -> R.drawable.ic_timeline_black_24dp
                AnnouncementModel.ModeModel.TRASH -> R.drawable.ic_whatshot_black_24dp
                AnnouncementModel.ModeModel.WEATHER ->  R.drawable.ic_sunny_black_24dp
            }

    @ColorRes
    private fun AnnouncementModel.ModeModel.toColorRes(): Int =
            when (this) {
                AnnouncementModel.ModeModel.EXCHANGE -> R.color.yellow_500
                AnnouncementModel.ModeModel.TRASH -> R.color.orange_500
                AnnouncementModel.ModeModel.WEATHER ->  R.color.red_500
            }
}
