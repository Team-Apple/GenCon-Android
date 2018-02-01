package com.github.teamapple.gencon.ui.main.tasks.model

import android.annotation.SuppressLint
import android.os.Parcelable
import com.github.teamapple.gencon.data.api.entity.response.EventResponse
import com.github.teamapple.gencon.model.PriorityModel
import com.github.teamapple.gencon.util.DateFormatter
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class EventModel(val id: Int,
                      val name: String,
                      val memo: String,
                      val startTime: String,
                      val endTime: String,
                      val priority: PriorityModel
) : Parcelable {
    companion object {
        internal fun convert(response: EventResponse, formatter: DateFormatter): EventModel {
            return EventModel(
                    id = response.id,
                    name = response.title,
                    memo = response.memo ?: "",
                    startTime = formatter.format(response.startAt),
                    endTime = formatter.format(response.endAt),
                    priority = PriorityModel.from(response.priority)
            )
        }
    }
}
