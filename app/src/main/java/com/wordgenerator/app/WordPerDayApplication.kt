package com.wordgenerator.app

import com.wordgenerator.app.di.ApplicationModule
import com.wordgenerator.app.di.DaggerWordPerDayAppComponent
import com.wordgenerator.app.di.WordPerDayAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector

class WordPerDayApplication : DaggerApplication(), HasAndroidInjector {

    override fun onCreate() {
        super.onCreate()

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerWordPerDayAppComponent.builder()
            .application(this)
            .applicationModule(ApplicationModule(this))
            .build()
}