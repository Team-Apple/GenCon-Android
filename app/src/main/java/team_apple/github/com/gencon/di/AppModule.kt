package team_apple.github.com.gencon.di

import android.content.Context
import dagger.Module
import dagger.Provides
import timber.log.Timber
import javax.inject.Singleton

@Module
class AppModule(@get:[Provides Singleton] val context: Context) {

    @Provides
    @Singleton
    fun provideTimberTree():Timber.Tree{
        return Timber.DebugTree()
    }
}
