package com.github.teamapple.gencon.ui.eventdetail.detail

import com.github.teamapple.gencon.domain.usecase.EventsUseCase

class EventDetailPresenter(private val usecase: EventsUseCase) : EventDetailContract.Presenter {
    private lateinit var view: EventDetailContract.View;

    override fun onResume(view: EventDetailContract.View) {
        this.view = view
    }

    override fun onPause() {

    }
}
