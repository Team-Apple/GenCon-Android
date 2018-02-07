package com.github.teamapple.gencon.persentaion.main.task

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.data.api.GenConApiClient
import com.github.teamapple.gencon.data.db.entity.mapper.toTaskEntities
import com.github.teamapple.gencon.databinding.FragmentTasksBinding
import com.github.teamapple.gencon.di.Injectable
import com.github.teamapple.gencon.util.view.SpaceItemDecoration
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject


class TaskFragment : Fragment(), Injectable {
    companion object {
        fun newInstance() = TaskFragment()
    }

    @Inject
    lateinit var apiClient: GenConApiClient

    private lateinit var binding: FragmentTasksBinding
    private val adapter = GroupAdapter<ViewHolder>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tasksRecycler.also { recyclerView ->
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.addItemDecoration(SpaceItemDecoration.createFromResource(context!!, R.dimen.recycler_view_item_margin))
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }
        apiClient.fetchAllTasksOfDay("2018-02-07")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            Timber.d("onsucsess")
                            adapter.clear()
                            adapter.addAll(it.toTaskEntities().toTaskModels().map { TaskItem(it) })
                        },
                        { Timber.e(it) }
                )

    }
}
