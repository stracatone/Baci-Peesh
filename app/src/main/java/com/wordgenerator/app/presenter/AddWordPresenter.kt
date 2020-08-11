package com.wordgenerator.app.presenter

import android.content.res.Resources
import android.util.Log
import com.wordgenerator.app.contracts.AddWordContract
import com.wordgenerator.app.R
import com.wordgenerator.app.data.WordsRepository
import com.wordgenerator.app.model.Word
import javax.inject.Inject

class AddWordPresenter @Inject constructor(private val view: AddWordContract.View, private val repository: WordsRepository,
                                           private val resources: Resources) : AddWordContract.Presenter {

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
        repository.saveWord(newWord)
                .also { Log.d("Read", "Value: ${newWord.toString()}") }
        // inform user
        view.showSuccessMessage(resources.getString(R.string.translation_saved_message))
    }
}