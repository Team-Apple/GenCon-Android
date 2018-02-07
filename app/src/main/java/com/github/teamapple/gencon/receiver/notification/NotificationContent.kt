package com.github.teamapple.gencon.receiver.notification

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class NotificationContent: Parcelable {
    abstract val title:  String

    @SuppressLint("ParcelCreator")
    @Parcelize
    data class EventNotification(override val title: String) : NotificationContent()
}
