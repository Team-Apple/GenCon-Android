package com.github.teamapple.gencon

import android.app.Application
import android.content.Context
import com.github.teamapple.gencon.di.AppComponent
import com.github.teamapple.gencon.di.AppModule
import com.github.teamapple.gencon.di.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen
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
        AndroidThreeTen.init(this);
    }

    companion object {
        fun appComponent(context: Context):AppComponent = (context.applicationContext as GenConApplication).component
    }
}
