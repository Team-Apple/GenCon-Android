package com.github.team_apple.gencon.presentation.ui.main.events

import android.content.Context
import com.github.team_apple.gencon.GenConApplication
import com.github.team_apple.gencon.di.AppComponent
import com.github.team_apple.gencon.di.scopes.FragmentScope
import dagger.Component

@FragmentScope
@Component(modules = arrayOf(EventsModule::class), dependencies = arrayOf(AppComponent::class))
interface EventsComponent {
    fun inject(fragment: EventsFragment)

    object Initializer{
        fun init(context: Context): EventsComponent =
            DaggerEventsComponent.builder()
                    .appComponent(GenConApplication.appComponent(context))
                    .build()

    }
}
