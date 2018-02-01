package com.github.teamapple.gencon.di

import com.github.teamapple.gencon.data.db.*
import dagger.Binds
import dagger.Module

@Module
abstract class DatabaseModule {

    @Binds
    abstract fun provideEventDatabase(database: EventRoomDatabase): EventDatabase

    @Binds
    abstract fun provideTaskDatabase(database: TaskRoomDatabase): TaskDatabase

    @Binds
    abstract fun provideAnnouncementDatabase(database: AnnouncementRoomDatabase): AnnouncementDatabase

}
