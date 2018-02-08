package com.github.teamapple.gencon.persentaion.main.events

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.databinding.FragmentEventsBinding
import com.github.teamapple.gencon.di.ViewModelFactory
import com.github.teamapple.gencon.util.ext.observe
import com.github.teamapple.gencon.util.view.SpaceItemDecoration
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import javax.inject.Inject

class EventsFragment : Fragment() {
    companion object {
        fun newInstance() = EventsFragment()
    }


    private lateinit var binding: FragmentEventsBinding
    private val adapter = GroupAdapter<ViewHolder>()
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: EventsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(EventsViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.eventsRecycler.also { recyclerView ->
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.addItemDecoration(SpaceItemDecoration.createFromResource(context!!, R.dimen.recycler_view_item_margin))
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }

        viewModel.events.observe(this, {
            it?.map { EventItem(it) }?.run {
                adapter.clear()
                if (isEmpty()){
                    binding.eventsInactiveGroup.visibility = View.VISIBLE
                }else{
                    binding.eventsInactiveGroup.visibility = View.GONE
                    adapter.addAll(this)
                }
            }
        })
    }
}
