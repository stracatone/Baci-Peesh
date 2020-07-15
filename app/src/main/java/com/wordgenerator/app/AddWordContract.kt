package com.wordgenerator.app

interface AddWordContract {

    interface View {
        // inform user about result
        fun showErrorMessage(message: String)

        // inform user about result
        fun showSuccessMessage(message: String)
    }

    interface Presenter {
        // stores new word to repository
        fun saveWord(word: String?, translation: String?)
    }
}