package com.github.team_apple.gencon.presentation.ui.main.events

import android.content.Intent
import com.github.team_apple.gencon.domain.usecase.EventsUseCase
import javax.inject.Inject


class EventsPresenter @Inject constructor(val useCase: EventsUseCase) : EventsContract.Presenter {
    lateinit var view: EventsContract.View
    override fun onResume(view: EventsContract.View) {
        this.view = view
    }
    override fun onPause() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }
}
