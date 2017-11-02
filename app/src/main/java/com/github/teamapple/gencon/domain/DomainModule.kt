package com.github.teamapple.gencon.domain

import com.github.teamapple.gencon.domain.usecase.EventsUseCase
import com.github.teamapple.gencon.domain.usecase.EventsUseCaseImpl
import com.github.teamapple.gencon.domain.usecase.TasksUseCase
import com.github.teamapple.gencon.domain.usecase.TasksUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DomainModule {

    @Binds
    @Singleton
    abstract fun bindsEventsUsecase(impl: EventsUseCaseImpl): EventsUseCase

    @Binds
    @Singleton
    abstract fun bindsTasksUsecase(impl: TasksUseCaseImpl): TasksUseCase
}
