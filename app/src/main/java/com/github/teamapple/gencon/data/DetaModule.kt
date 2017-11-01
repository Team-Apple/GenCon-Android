package com.github.teamapple.gencon.data

import com.github.teamapple.gencon.data.network.ApiClient
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class DetaModule {
    companion object {
        private const val BASE_URL = "https://gencon-web.herokuapp.com/api"
    }

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi,okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
    }

    @Provides
    @Singleton
    fun provideMoshi():Moshi{
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }

    @Provides
    @Singleton
    private fun okhhtp3Client(): OkHttpClient{
        return OkHttpClient.Builder().build()
    }

}
