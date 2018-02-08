package com.github.teamapple.gencon.persentaion.main.announcement

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.teamapple.gencon.R
import com.github.teamapple.gencon.databinding.FragmentAnnouncementBinding
import com.github.teamapple.gencon.di.Injectable
import com.github.teamapple.gencon.di.ViewModelFactory
import com.github.teamapple.gencon.util.ext.observe
import com.github.teamapple.gencon.util.view.SpaceItemDecoration
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import javax.inject.Inject

class AnnouncementsFragment : Fragment(), Injectable {
    private lateinit var binding: FragmentAnnouncementBinding
    private val adapter = GroupAdapter<ViewHolder>()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: AnnouncementsViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(AnnouncementsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnnouncementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.announcementRecycler.also { recyclerView ->
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.addItemDecoration(SpaceItemDecoration.createFromResource(context!!, R.dimen.recycler_view_item_margin))
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }
        viewModel.announcements.observe(this, {
            it?.map { AnnouncementItem(it) }?.run {
                if (isEmpty()){
                    binding.announcementInactiveGroup.visibility = View.VISIBLE
                }else{
                    binding.announcementInactiveGroup.visibility = View.GONE
                }
            }
        })
    }
}
