package com.github.teamapple.gencon.persentaion.main.events

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.teamapple.gencon.databinding.FragmentEventsBinding

class EventsFragment : Fragment() {
    companion object {
        fun newInstance() = EventsFragment()
    }


    private lateinit var binding: FragmentEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //EventsComponent.Initializer.init(context!!).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*binding.recyclerView.also { recyclerView ->
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.addItemDecoration(SpaceItemDecoration.createByDpSize(context!!, 4))
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }*/
    }

    override fun onResume() {
        super.onResume()
        /*presenter.onResume(this)
        if (adapter.isEmpty()) {
            presenter.loadDaysEvents(binding.dateSelectContainer.getSelectedDate())
        }
        binding.swipeRefreshLayout.setOnRefreshListener {
            presenter.loadDaysEvents(binding.dateSelectContainer.getSelectedDate())
        }

        binding.dateSelectContainer.setListener(object : DateSelectLayout.DateSelectListener{
            override fun onSelectDate(date: DateModel) {
                presenter.loadDaysEvents(date)
            }
        })*/
    }

    override fun onPause() {
        super.onPause()
        //presenter.onPause()
    }
}
