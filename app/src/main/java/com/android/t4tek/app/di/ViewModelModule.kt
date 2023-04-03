//package com.android.t4tek.app.di
//
//import androidx.lifecycle.ViewModelProvider
//import com.android.t4tek.app.main.MainActivity
//import com.android.t4tek.app.main.MainActivityVM
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ActivityComponent
//import dagger.hilt.android.qualifiers.ActivityContext
//
//@Module
//@InstallIn(ActivityComponent::class)
//class ViewModelModule {
//    @Provides
//    fun provideMainActivity(activity: MainActivity): MainActivity {
//        return activity
//    }
//
//    @Provides
//    fun provideMainViewModel(@ActivityContext activity: MainActivity): MainActivityVM {
//        return ViewModelProvider(activity)[MainActivityVM::class.java]
//    }
//}