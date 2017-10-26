package com.github.team_apple.gencon.presentation.ui.main.events

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.team_apple.gencon.R

class EventsFragment : Fragment(), EventsContract.View {
    companion object {
        fun newInstance() = EventsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_events, container, false)
    }


}
