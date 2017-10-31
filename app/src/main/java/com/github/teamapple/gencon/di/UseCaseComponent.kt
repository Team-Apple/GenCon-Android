package com.github.teamapple.gencon.di

import com.github.teamapple.gencon.domain.usecase.EventsUseCase

interface UseCaseComponent {
    fun eventsUseCase(): EventsUseCase
}
