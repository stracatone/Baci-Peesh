package com.wordgenerator.app.presenter

import com.wordgenerator.app.ReadWordContract
import com.wordgenerator.app.WordsRepository

class ReadWordPresenter(private val readWordView: ReadWordContract.View, private val repository: WordsRepository) : ReadWordContract.Presenter {

    override fun getRandomWord() {
        val word = repository.getRandomWord()
        readWordView.showTodayWord(word?.name?.plus(" -> ")
                                           .plus(word?.meaning))
    }
}