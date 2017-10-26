package com.github.team_apple.gencon

import android.app.Application
import android.content.Context
import com.github.team_apple.gencon.di.AppComponent
import com.github.team_apple.gencon.di.AppModule
import com.github.team_apple.gencon.di.DaggerAppComponent
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

    companion object {
        fun appComponent(context: Context):AppComponent = (context.applicationContext as GenConApplication).component
    }
}
