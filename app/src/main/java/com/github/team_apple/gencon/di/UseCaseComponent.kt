package com.github.team_apple.gencon.di

import com.github.team_apple.gencon.domain.usecase.EventsUseCase

interface UseCaseComponent {
    fun eventsUseCase(): EventsUseCase
}
