package com.github.teamapple.gencon.ui.main.events

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.ui.main.ParentEventSubscriber
import com.github.teamapple.widget.SpaceItemDecoration
import kotlinx.android.synthetic.main.fragment_events.*
import javax.inject.Inject

class EventsFragment : Fragment(), EventsContract.View, ParentEventSubscriber {
    companion object {
        fun newInstance() = EventsFragment()
    }

    @Inject lateinit var presenter: EventsContract.Presenter
    @Inject lateinit var navigator: EventsContract.Navigator

    private val adapter = EventsRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventsComponent.Initializer.init(context).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(SpaceItemDecoration.createByDpSize(context, 4))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume(this)
        if (adapter.isEmpty()) {
            presenter.loadTodayEvent()
        }
        swipeRefreshLayout.setOnRefreshListener {
            presenter.loadTodayEvent()
        }
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun updateEvents(events: List<EventModel>) {
        adapter.updateEvents(events)
    }

    override fun setLoadingIndicator(active: Boolean) {
        swipeRefreshLayout.post {
            swipeRefreshLayout.isRefreshing = active
        }
    }

    override fun setNoEventsView(shown: Boolean) {
        if (shown) {
            recyclerView.visibility = View.GONE
            emptyView.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
            emptyView.visibility = View.GONE
        }
    }

    override fun showMessage(message: String) {
        //todo あとで実装
    }

    override fun onClickCreateButton() {
        navigator.navigateToEventEdit(activity)
    }

}
