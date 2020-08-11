package com.wordgenerator.app.contracts

import com.wordgenerator.app.model.Word

interface EditWordContract {

    interface View {
        // show selected word
        fun showSelectedWord(word: Word?)

        // inform user about result
        fun showErrorMessage(message: String)

        // inform user about result
        fun showSuccessMessage(message: String)
    }

    interface Presenter {
        // get word to edit
        fun getSelectedWord()

        // stores new word to repository
        fun saveWord(word: String?, translation: String?)
    }
}