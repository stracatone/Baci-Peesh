package com.wordgenerator.app.di

import com.wordgenerator.app.adapters.WordsRecyclerViewAdapter
import dagger.Module
import dagger.Provides
import io.paperdb.Book
import io.paperdb.Paper
import javax.inject.Singleton

@Module(includes = [ApplicationModule::class])
class WordsModule {

    @Singleton
    @Provides
    fun provideDatabase(): Book {
        return Paper.book()
    }

    @Provides
    fun provideWordsAdapter(): WordsRecyclerViewAdapter {
        return WordsRecyclerViewAdapter(emptyList())
    }
}