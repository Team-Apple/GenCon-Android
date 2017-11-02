package com.github.teamapple.gencon.ui.main.events

import android.content.Context
import com.github.teamapple.gencon.GenConApplication
import com.github.teamapple.gencon.di.AppComponent
import com.github.teamapple.gencon.di.scopes.FragmentScope
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
