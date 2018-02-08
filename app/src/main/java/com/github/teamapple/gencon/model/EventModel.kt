package com.github.teamapple.gencon.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class EventModel(val id: Int,
                      val name: String,
                      val memo: String,
                      val startAt: String,
                      val endAt: String,
                      val priority: PriorityModel
):Parcelable
