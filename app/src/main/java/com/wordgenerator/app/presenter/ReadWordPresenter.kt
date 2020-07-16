package com.wordgenerator.app.presenter

import android.content.res.Resources
import android.util.Log
import com.wordgenerator.app.R
import com.wordgenerator.app.contracts.ReadWordContract
import com.wordgenerator.app.data.WordsRepository
import javax.inject.Inject

class ReadWordPresenter @Inject constructor(private val view: ReadWordContract.View, private val repository: WordsRepository,
                                            private val resources: Resources) : ReadWordContract.Presenter {

    override fun getRandomWord() {
        val word = repository.getRandomWord()
        val formattedWord = if (word != null) word.name?.plus(" -> ")
                .plus(word.meaning) else resources.getString(R.string.empty_database_message)
        view.showTodayWord(formattedWord)
                .also { Log.d("Read", "Value: ${word.toString()}") }
    }
}