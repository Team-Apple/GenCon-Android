package com.github.teamapple.gencon.data.api.entity.params


class AnnouncementParams {

    data class CreateParams(
            val timing: Boolean,
            val mode: Int
    )

    data class EditParams(
            val id: Int,
            val timing: Boolean,
            val mode: Int
    )
}
