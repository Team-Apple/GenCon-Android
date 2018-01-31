package com.github.teamapple.gencon.ui.eventdetail.edit;

import com.github.teamapple.gencon.ui.eventdetail.detail.EventDetailContract

class EventDetailPresenter() : EventDetailContract.Presenter {
    private lateinit var view: EventDetailContract.View;

    override fun onResume(view: EventDetailContract.View) {
        this.view = view
    }

    override fun onPause() {

    }
}
