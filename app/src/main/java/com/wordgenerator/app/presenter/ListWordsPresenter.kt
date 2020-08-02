package com.wordgenerator.app.presenter

import com.wordgenerator.app.contracts.ListWordsContract
import com.wordgenerator.app.data.CalendarRepository
import com.wordgenerator.app.data.WordsRepository
import com.wordgenerator.app.model.Word
import java.util.*
import javax.inject.Inject

class ListWordsPresenter @Inject constructor(private val view: ListWordsContract.View, private val wordsRepo: WordsRepository,
                                             private val calendarRepo: CalendarRepository) : ListWordsContract.Presenter {

    override fun getWordsToShow() {
        view.updateWordsList(wordsRepo.getAllWords())
    }

    override fun saveData(data: List<Word>) {
        wordsRepo.updateList(data)
    }

    override fun setSelected(position: Int) {
        wordsRepo.setSelectedPosition(position)
    }

    override fun checkAddStatus() {
        val lastDayAddShown = Calendar.getInstance()
                .get(Calendar.DAY_OF_YEAR)
        val currentDayOfYear = calendarRepo.getLastDayFullAddShowed()
        view.shouldShowAdd(lastDayAddShown != currentDayOfYear)
    }

    override fun saveAddStatus() {
        calendarRepo.saveLastDayFullAddShowed(Calendar.getInstance()
                                                      .get(Calendar.DAY_OF_YEAR))
    }
}