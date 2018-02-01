package com.github.teamapple.gencon

import android.app.Activity
import android.app.Application
import android.content.Context
import com.github.teamapple.gencon.di.AppComponent
import com.github.teamapple.gencon.di.AppModule
import com.github.teamapple.gencon.di.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class GenConApplication : Application(), HasActivityInjector {

    private val component: AppComponent by  lazy{
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        Timber.plant(Timber.DebugTree())
        AndroidThreeTen.init(this);
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    companion object {
        fun appComponent(context: Context):AppComponent = (context.applicationContext as GenConApplication).component
    }
}
