package com.wordgenerator.app.presenter

import android.content.res.Resources
import android.util.Log
import com.wordgenerator.app.AddWordContract
import com.wordgenerator.app.R
import com.wordgenerator.app.WordsRepository
import com.wordgenerator.app.model.Word

class AddWordPresenter(private val addWordView: AddWordContract.View, private val repository: WordsRepository, private val resources: Resources) :
        AddWordContract.Presenter {

    override fun saveWord(word: String?, translation: String?) {
        if (word.isNullOrEmpty()) {
            addWordView.showErrorMessage(resources.getString(R.string.word_missing_error))
            return
        }
        if (translation.isNullOrEmpty()) {
            addWordView.showErrorMessage(resources.getString(R.string.translation_missing_error))
            return
        }
        // save new word to database
        val newWord = Word(word, translation)
        repository.saveWord(newWord)
                .also { Log.d("Read", "Value: ${newWord.toString()}") }
        // inform user
        addWordView.showSuccessMessage(resources.getString(R.string.translation_saved_message))
    }
}