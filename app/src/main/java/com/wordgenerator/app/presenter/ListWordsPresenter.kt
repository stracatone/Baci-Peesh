package com.wordgenerator.app.presenter

import com.wordgenerator.app.contracts.ListWordsContract
import com.wordgenerator.app.data.WordsRepository
import com.wordgenerator.app.model.Word
import javax.inject.Inject

class ListWordsPresenter @Inject constructor(private val view: ListWordsContract.View, private val repository: WordsRepository) :
        ListWordsContract.Presenter {

    override fun getWordsToShow() {
        view.updateWordsList(repository.getAllWords())
    }

    override fun saveData(data: List<Word>) {
        repository.updateList(data)
    }

    override fun setSelected(position: Int) {
        repository.setSelectedPosition(position)
    }
}