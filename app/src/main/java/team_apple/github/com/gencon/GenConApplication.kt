package team_apple.github.com.gencon

import android.app.Application
import team_apple.github.com.gencon.di.AppComponent
import team_apple.github.com.gencon.di.AppModule
import team_apple.github.com.gencon.di.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject

class GenConApplication : Application() {
    private val component: AppComponent by  lazy{
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
    @Inject lateinit var timberTree:Timber.Tree

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        Timber.plant(timberTree)
    }
}
