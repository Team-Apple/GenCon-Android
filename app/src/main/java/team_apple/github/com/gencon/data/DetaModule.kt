package team_apple.github.com.gencon.data

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import team_apple.github.com.gencon.data.network.ApiClient

@Module
class DetaModule {
    companion object {
        private const val BASE_URL = ""
    }

    fun provideApiClient(retrofit: Retrofit):ApiClient{
        return retrofit.create(ApiClient::class.java)
    }

    fun provideRetrofit(moshi: Moshi,okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
    }


    fun provideMoshi():Moshi{
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }

    private fun okhhtp3Client(): OkHttpClient{
        return OkHttpClient.Builder().build()
    }

}
