package com.github.teamapple.gencon.persentaion.main.tasks

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.teamapple.gencon.databinding.FragmentTasksBinding
import com.github.teamapple.gencon.model.TaskModel
import com.github.teamapple.gencon.util.view.SpaceItemDecoration
import javax.inject.Inject

class TasksFragment : Fragment(), TasksContract.View {
    companion object {
        fun newInstance() = TasksFragment()
    }

    @Inject lateinit var presenter: TasksContract.Presenter
    private lateinit var binding: FragmentTasksBinding
    //private val adapter = TasksRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TasksComponent.Initializer.init(context!!).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.also { recyclerView ->
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.addItemDecoration(SpaceItemDecoration.createByDpSize(context!!, 4))
            recyclerView.setHasFixedSize(true)
            //recyclerView.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume(this)
        /*if (adapter.isEmpty()) {
            //presenter.loadDaysTasks(binding.dateSelectContainer.getSelectedDate())
        }*/
        binding.swipeRefreshLayout.setOnRefreshListener {
            //presenter.loadDaysTasks(binding.dateSelectContainer.getSelectedDate())
        }
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun updateEvents(events: List<TaskModel>) {
        //adapter.updateTasks(events)
    }

    override fun setLoadingIndicator(active: Boolean) {
        binding.swipeRefreshLayout.post {
            binding.swipeRefreshLayout.isRefreshing = active
        }
    }

    override fun setNoEventsView(shown: Boolean) {
        //binding.recyclerView.visibility(!shown)
        //binding.emptyView.visibility(shown)
    }

    override fun showMessage(message: String) {
        //todo あとで実装
    }



}
