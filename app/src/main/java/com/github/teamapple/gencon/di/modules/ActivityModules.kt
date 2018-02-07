package com.github.teamapple.gencon.di.modules

import com.github.teamapple.gencon.di.activitymodules.MainActivityModule
import com.github.teamapple.gencon.di.scopes.ActivityScope
import com.github.teamapple.gencon.persentaion.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModules {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun contributeMainActivity(): MainActivity
}
