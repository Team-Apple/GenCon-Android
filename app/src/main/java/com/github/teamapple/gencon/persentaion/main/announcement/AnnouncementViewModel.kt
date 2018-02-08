package com.github.teamapple.gencon.persentaion.main.announcement

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.github.teamapple.gencon.data.repository.AnnouncementRepository
import com.github.teamapple.gencon.model.AnnouncementModel
import com.github.teamapple.gencon.util.ext.toLiveData
import javax.inject.Inject

class AnnouncementViewModel @Inject constructor(
        repository: AnnouncementRepository
) : ViewModel() {

    val announcements: LiveData<List<AnnouncementModel>> by lazy {
        repository.announcements.toLiveData()
    }


}
