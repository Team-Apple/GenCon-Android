package com.github.teamapple.gencon.ui.eventdetail.detail

class EventDetailPresenter() : EventDetailContract.Presenter {
    private lateinit var view: EventDetailContract.View;

    override fun onResume(view: EventDetailContract.View) {
        this.view = view
    }

    override fun onPause() {

    }
}
