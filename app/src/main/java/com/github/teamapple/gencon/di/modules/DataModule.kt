package com.github.teamapple.gencon.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.github.teamapple.gencon.data.api.GenConApiClient
import com.github.teamapple.gencon.data.api.response.mapper.LocalDateTimeAdapter
import com.github.teamapple.gencon.data.db.AppDatabase
import com.github.teamapple.gencon.data.db.dao.AnnouncementDao
import com.github.teamapple.gencon.data.db.dao.EventDao
import com.github.teamapple.gencon.data.db.dao.TaskDao
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.threeten.bp.LocalDateTime
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module(includes = [DatabaseModule::class, RepositoryModule::class])
class DataModule {
    companion object {
        private const val BASE_URL = "https://gencon-web.herokuapp.com/api/"
    }

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): GenConApiClient {
        return retrofit.create(GenConApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .add(LocalDateTime::class.java, LocalDateTimeAdapter())
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(StethoInterceptor())
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.HEADERS
                })
                .build()
    }

    @Provides
    @Singleton
    fun provideRoom(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "gencon.db")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideTaskDao(db: AppDatabase): TaskDao = db.taskDao()

    @Provides
    @Singleton
    fun provideEventDao(db: AppDatabase): EventDao = db.eventDao()

    @Provides
    @Singleton
    fun provideAnnouncementDao(db: AppDatabase): AnnouncementDao = db.announcementDao()


}
