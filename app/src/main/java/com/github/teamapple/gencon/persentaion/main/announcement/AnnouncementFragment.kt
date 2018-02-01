package com.github.teamapple.gencon.persentaion.main.announcement

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.teamapple.gencon.data.repository.AnnouncementRepository
import com.github.teamapple.gencon.databinding.FragmentAnnouncementBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class AnnouncementFragment : Fragment() {
    lateinit var binding: FragmentAnnouncementBinding

    @Inject
    lateinit var repository: AnnouncementRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnnouncementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            repository.announcements
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onNext = {

                            },
                            onError = {

                            }
                    )
            repository.refreshAnnouncements()
                    .onErrorComplete()
                    .subscribe()
    }

    override fun onResume() {
        super.onResume()
    }
}
