package team_apple.github.com.gencon.di

import dagger.Component
import team_apple.github.com.gencon.GenConApplication
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(application: GenConApplication)
}
