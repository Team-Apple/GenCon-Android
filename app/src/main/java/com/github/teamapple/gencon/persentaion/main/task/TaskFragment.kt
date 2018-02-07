package com.github.teamapple.gencon.persentaion.main.task

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.teamapple.gencon.databinding.FragmentTasksBinding
import com.github.teamapple.gencon.di.Injectable
import javax.inject.Inject

class TaskFragment : Fragment(), Injectable {
    companion object {
        fun newInstance() = TaskFragment()
    }

    @Inject
    lateinit var viewModel: TasksViewModel
    private lateinit var binding: FragmentTasksBinding
    //private val adapter = TasksRecyclerAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*viewModel.tasks.observe(this, {
            Timber.d(it.toString())
        })*/
        /*binding.recyclerView.also { recyclerView ->
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.addItemDecoration(SpaceItemDecoration.createByDpSize(context!!, 4))
            recyclerView.setHasFixedSize(true)
            //recyclerView.adapter = adapter
        }*/
    }

    override fun onResume() {
        super.onResume()
        //presenter.onResume(this)
        /*if (adapter.isEmpty()) {
            //presenter.loadDaysTasks(binding.dateSelectContainer.getSelectedDate())
        }*/
        /*binding.swipeRefreshLayout.setOnRefreshListener {
            //presenter.loadDaysTasks(binding.dateSelectContainer.getSelectedDate())
        }*/
    }

    override fun onPause() {
        super.onPause()
        //presenter.onPause()
    }

}
