package com.android.t4tek.app.di

import android.content.Context
import android.content.SharedPreferences
import com.android.utils.SharedPrefsUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
class PreferenceModule {

    @Singleton
    @Provides
    fun provideShared(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(SharedPrefsUtils.PREF_NAME, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(sharedPreferences: SharedPreferences): SharedPrefsUtils {
        return SharedPrefsUtils(sharedPreferences)
    }
}