package com.wordgenerator.app.di

import com.wordgenerator.app.WordPerDayApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, MainActivityModule::class, AddWordFragmentModule::class, ReadFragmentModule::class, ListWordsFragmentModule::class, WordsModule::class])
interface WordPerDayAppComponent : AndroidInjector<WordPerDayApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: WordPerDayApplication): Builder

        fun applicationModule(applicationModule: ApplicationModule): Builder

        fun build(): WordPerDayAppComponent
    }
}