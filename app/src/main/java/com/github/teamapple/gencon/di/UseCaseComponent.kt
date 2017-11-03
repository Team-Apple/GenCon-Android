package com.github.teamapple.gencon.di

import com.github.teamapple.gencon.domain.usecase.EventsUseCase
import com.github.teamapple.gencon.domain.usecase.TasksUseCase

interface UseCaseComponent {
    fun eventsUseCase(): EventsUseCase
    fun tasksUseCase(): TasksUseCase
}
