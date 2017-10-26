package com.github.team_apple.gencon.domain.usecase

import com.github.team_apple.gencon.domain.model.DateModel
import com.github.team_apple.gencon.domain.model.EventModel
import io.reactivex.Single

interface EventsUseCase {
    fun getDailyEvents(date: DateModel): Single<List<EventModel>>
}
