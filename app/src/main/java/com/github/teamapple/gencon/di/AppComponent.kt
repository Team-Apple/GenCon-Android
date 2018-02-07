package com.github.teamapple.gencon.di

import com.github.teamapple.gencon.App
import com.github.teamapple.gencon.di.modules.ActivityModules
import com.github.teamapple.gencon.di.modules.AppModule
import com.github.teamapple.gencon.di.modules.DataModule
import com.github.teamapple.gencon.di.modules.ViewModelModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityModules::class,
    DataModule::class,
    ViewModelModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun appModule(module: AppModule): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}
