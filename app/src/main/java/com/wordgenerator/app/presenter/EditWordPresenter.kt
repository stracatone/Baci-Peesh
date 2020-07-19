package com.wordgenerator.app.presenter

import android.content.res.Resources
import android.util.Log
import com.wordgenerator.app.R
import com.wordgenerator.app.contracts.EditWordContract
import com.wordgenerator.app.data.WordsRepository
import com.wordgenerator.app.model.Word
import javax.inject.Inject

class EditWordPresenter @Inject constructor(private val view: EditWordContract.View, private val repository: WordsRepository,
                                            private val resources: Resources) : EditWordContract.Presenter {
    override fun getSelectedWord() {
        val word = repository.getSelectedWord()
        view.showSelectedWord(word)
    }

    override fun saveWord(word: String?, translation: String?) {
        if (word.isNullOrEmpty()) {
            view.showErrorMessage(resources.getString(R.string.word_missing_error))
            return
        }
        if (translation.isNullOrEmpty()) {
            view.showErrorMessage(resources.getString(R.string.translation_missing_error))
            return
        }
        // save new word to database
        val newWord = Word(word, translation, true)
        repository.updateSelectedWord(newWord)
                .also { Log.d("Updated", "Value: $newWord") }
        // inform user
        view.showSuccessMessage(resources.getString(R.string.translation_updated_message))
    }
}