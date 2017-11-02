package com.github.teamapple.gencon.ui.main.tasks

import android.content.Context
import com.github.teamapple.gencon.GenConApplication
import com.github.teamapple.gencon.di.AppComponent
import com.github.teamapple.gencon.di.scopes.FragmentScope
import dagger.Component

@FragmentScope
@Component(modules = arrayOf(TasksModule::class), dependencies = arrayOf(AppComponent::class))
interface TasksComponent {
    fun inject(fragment: TasksFragment)

    object Initializer{
        fun init(context: Context): TasksComponent =
            DaggerTasksComponent.builder()
                    .appComponent(GenConApplication.appComponent(context))
                    .build()

    }
}
