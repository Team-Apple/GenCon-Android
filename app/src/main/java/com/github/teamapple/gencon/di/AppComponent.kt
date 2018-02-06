package com.github.teamapple.gencon.di

import com.github.teamapple.gencon.App
import com.github.teamapple.gencon.di.modules.AppModule
import com.github.teamapple.gencon.di.modules.DataModule
import com.github.teamapple.gencon.di.modules.DatabaseModule
import com.github.teamapple.gencon.di.modules.RepositoryModule
import com.github.teamapple.gencon.persentaion.main.MainActivityModuleBuilder
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class,
    DataModule::class,
    DatabaseModule::class,
    RepositoryModule::class,
    MainActivityModuleBuilder::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun appModule(module: AppModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}
