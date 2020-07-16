package com.wordgenerator.app.contracts

import com.wordgenerator.app.model.Word

interface ListWordsContract {

    interface View {
        // update list with data
        fun updateWordsList(data: List<Word>?)
    }

    interface Presenter {
        // get words from DB
        fun getWordsToShow()
    }
}