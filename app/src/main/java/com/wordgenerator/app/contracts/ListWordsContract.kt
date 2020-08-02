package com.wordgenerator.app.contracts

import com.wordgenerator.app.model.Word

interface ListWordsContract {

    interface View {
        // update list with data
        fun updateWordsList(data: List<Word>?)

        // open edit word screen
        fun openDetails(position: Int)

        // should add be displayed
        fun shouldShowAdd(shouldShowAdd: Boolean)
    }

    interface Presenter {
        // get words from DB
        fun getWordsToShow()

        // save data to DB
        fun saveData(data: List<Word>)

        // set selection
        fun setSelected(position: Int)

        // check if add should be displayed
        fun checkAddStatus()

        // save that add has been shown
        fun saveAddStatus()
    }
}