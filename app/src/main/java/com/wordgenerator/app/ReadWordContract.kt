package com.wordgenerator.app

interface ReadWordContract {

    interface View {
        fun showTodayWord(word: String)
    }

    interface Presenter {
        fun getRandomWord()
    }
}