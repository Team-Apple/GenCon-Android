package com.github.teamapple.gencon.presentation.ui.main.events

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.domain.model.EventModel
import com.github.teamapple.gencon.presentation.common.SpaceItemDecoration
import com.github.teamapple.gencon.presentation.ui.main.ParentEventSubscriber
import kotlinx.android.synthetic.main.fragment_events.*
import javax.inject.Inject

class EventsFragment : Fragment(), EventsContract.View ,ParentEventSubscriber {
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
        recyclerView.addItemDecoration(SpaceItemDecoration.createByDpSize(context,4))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume(this)
        presenter.loadTodayEvent()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data)
    }

    override fun updateEvents(events: List<EventModel>) {
        adapter.updateEvents(events)
    }

    override fun setLoadingIndicator(active: Boolean) {
        //todo あとで実装
    }

    override fun showNoEvents() {
        //todo あとで実装
    }

    override fun showMessage(message: String) {
        //todo あとで実装
    }

    override fun onClickCreateButton() {
        navigator.navigateToEventEdit(activity)
    }

}
