package com.wordgenerator.app.di

import com.wordgenerator.app.contracts.AddWordContract
import com.wordgenerator.app.contracts.ReadWordContract
import com.wordgenerator.app.view.AddWordFragment
import com.wordgenerator.app.view.ReadFragment
import dagger.Binds
import dagger.Module

@Module
abstract class ReadWordViewModule {

    @Binds
    abstract fun provideReadWordView(view: ReadFragment): ReadWordContract.View
}

@Module
abstract class AddWordViewModule {

    @Binds
    abstract fun provideAddWordView(view: AddWordFragment): AddWordContract.View
}