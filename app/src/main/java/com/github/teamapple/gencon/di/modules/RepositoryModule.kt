package com.github.teamapple.gencon.di.modules

import com.github.teamapple.gencon.data.repository.*
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsEventRepository(repository: TaskRepositoryImpl): TaskRepository

    @Binds
    @Singleton
    fun bindsTaskRepository(repository: EventRepositoryImpl): EventRepository


    @Binds
    @Singleton
    fun bindsAnnnouncementRepository(repository: AnnouncementRepositoryImpl): AnnouncementRepository


}
