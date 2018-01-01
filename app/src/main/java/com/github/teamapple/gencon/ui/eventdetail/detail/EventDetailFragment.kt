package com.github.teamapple.gencon.ui.eventdetail.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.teamapple.gencon.databinding.FragmentEventDetailBinding
import com.github.teamapple.gencon.domain.model.EventModel

class EventDetailFragment : Fragment() {
    private lateinit var binging:FragmentEventDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binging = FragmentEventDetailBinding.inflate(inflater,container,false)
        return binging.root
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    companion object {
        private const val KEY_EVENT  = "key_event"
        fun newInstance(eventModel: EventModel) = EventDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_EVENT, eventModel)
            }
        }
    }
}
