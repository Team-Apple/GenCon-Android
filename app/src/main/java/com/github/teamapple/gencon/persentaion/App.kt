package com.github.teamapple.gencon.persentaion

import android.app.Activity
import android.app.Application
import com.github.teamapple.gencon.di.DaggerAppComponent
import com.github.teamapple.gencon.di.applyAutoInjecter
import com.github.teamapple.gencon.di.modules.AppModule
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
                .inject(this)
        applyAutoInjecter()
        Timber.plant(Timber.DebugTree())
        AndroidThreeTen.init(this);
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }


}
