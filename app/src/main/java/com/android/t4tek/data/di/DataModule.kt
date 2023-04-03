package com.android.t4tek.data.di

import android.content.Context
import com.android.t4tek.BuildConfig
import com.android.t4tek.data.local.AppDatabase
import com.android.t4tek.data.remote.ApiHelper
import com.android.t4tek.data.remote.ApiHelperImpl
import com.android.t4tek.data.remote.ApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(
            context = appContext
        )
    }


    @Provides
    fun provideAPIURL() = BuildConfig.API_URL

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
//            .add(AbsPlayerConverter)
//            .add(AbsRegionConverter)
//            .add(AbsTournamentConverter)
//            .add(MatchConverter)
//            .add(RankedPlayerConverter)
//            .add(SimpleDateConverter)
            .add(KotlinJsonAdapterFactory())
            .build()
//        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(moshi: Moshi): Converter.Factory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        ApiUrl: String,
        converterFactory: Converter.Factory
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .baseUrl(ApiUrl)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

}