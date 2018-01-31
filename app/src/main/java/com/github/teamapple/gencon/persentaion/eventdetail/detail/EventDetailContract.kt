package com.github.teamapple.gencon.ui.eventdetail.detail

interface EventDetailContract {
    interface Presenter {
        fun onResume(view: View)
        fun onPause()
    }

    interface View{

    }
}
