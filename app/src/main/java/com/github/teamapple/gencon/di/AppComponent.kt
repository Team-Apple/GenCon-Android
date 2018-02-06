package com.github.teamapple.gencon.di

import android.app.Application
import com.github.teamapple.gencon.di.modules.AppModule
import com.github.teamapple.gencon.di.modules.DataModule
import com.github.teamapple.gencon.di.modules.DatabaseModule
import com.github.teamapple.gencon.di.modules.RepositoryModule
import com.github.teamapple.gencon.persentaion.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    DataModule::class,
    RepositoryModule::class,
    DatabaseModule::class ])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun appModule(module: AppModule): Builder
        fun build(): AppComponent
    }

    fun inject(application: App)
}
