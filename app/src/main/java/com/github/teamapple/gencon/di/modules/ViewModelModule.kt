package com.github.teamapple.gencon.di.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import com.github.teamapple.gencon.di.ViewModelInjectorFactory
import dagger.Module
import dagger.Provides


@Module
abstract class ViewModelModule<VM : ViewModel>(private val clazz: Class<VM>) {

    @Provides
    fun provideViewModel(activity: AppCompatActivity, factory: ViewModelInjectorFactory<VM>): VM {
        return ViewModelProviders.of(activity, factory).get(clazz)
    }
}
