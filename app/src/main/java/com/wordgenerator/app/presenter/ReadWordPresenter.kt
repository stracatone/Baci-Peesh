package com.wordgenerator.app.presenter

import android.content.res.Resources
import android.util.Log
import com.wordgenerator.app.R
import com.wordgenerator.app.ReadWordContract
import com.wordgenerator.app.WordsRepository

class ReadWordPresenter(private val readWordView: ReadWordContract.View, private val repository: WordsRepository, private val resources: Resources) :
        ReadWordContract.Presenter {

    override fun getRandomWord() {
        val word = repository.getRandomWord()
        val formattedWord = if (word != null) word.name?.plus(" -> ")
                .plus(word.meaning) else resources.getString(R.string.empty_database_message)
        readWordView.showTodayWord(formattedWord)
                .also { Log.d("Read", "Value: ${word.toString()}") }
    }
}