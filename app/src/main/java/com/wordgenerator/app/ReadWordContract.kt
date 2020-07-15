package com.wordgenerator.app

interface ReadWordContract {

    interface View {
        // presents user random word with its translation
        fun showTodayWord(word: String)
    }

    interface Presenter {
        // return random word from repository
        fun getRandomWord()
    }
}