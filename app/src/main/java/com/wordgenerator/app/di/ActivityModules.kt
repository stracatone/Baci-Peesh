package com.wordgenerator.app.di

import com.wordgenerator.app.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun bindActivity(): MainActivity
}