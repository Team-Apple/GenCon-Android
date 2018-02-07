package com.github.teamapple.gencon.di.modules

import com.github.teamapple.gencon.domain.repository.TaskRepository
import com.github.teamapple.gencon.data.repository.TaskRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsEventsRepository(repository: TaskRepositoryImpl): TaskRepository
}
