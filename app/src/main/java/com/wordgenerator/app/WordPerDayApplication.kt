package com.wordgenerator.app

import com.google.android.gms.ads.MobileAds
import com.wordgenerator.app.di.ApplicationModule
import com.wordgenerator.app.di.DaggerWordPerDayAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector
import io.paperdb.Paper

class WordPerDayApplication : DaggerApplication(), HasAndroidInjector {

    override fun onCreate() {
        super.onCreate()
        // init database
        Paper.init(applicationContext)
        // google ad mob
        MobileAds.initialize(this) {}
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerWordPerDayAppComponent.builder()
            .application(this)
            .applicationModule(ApplicationModule(this))
            .build()
}