package com.wordgenerator.app.di

import com.wordgenerator.app.view.AddWordFragment
import com.wordgenerator.app.view.ReadFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AddWordFragmentModule {

    @ContributesAndroidInjector(modules = [AddWordViewModule::class])
    abstract fun bindFragment(): AddWordFragment
}

@Module
abstract class ReadFragmentModule {

    @ContributesAndroidInjector(modules = [ReadWordViewModule::class])
    abstract fun bindFragment(): ReadFragment
}