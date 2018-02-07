package com.github.teamapple.gencon.di.modules

import android.arch.lifecycle.ViewModelProvider
import com.github.teamapple.gencon.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
