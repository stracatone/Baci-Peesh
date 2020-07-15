package com.wordgenerator.app.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: Application) {

    @Provides
    fun providesContext(): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    internal fun provideResources(): Resources {
        return app.applicationContext.resources
    }
}