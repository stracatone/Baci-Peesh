package com.wordgenerator.app.data

import com.wordgenerator.app.model.Word
import com.wordgenerator.app.util.Constants
import io.paperdb.Book
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WordsRepository @Inject constructor(private val db: Book?) {

    var word: Word? = null

    private var selectedPosition: Int? = null

    fun getAllWords(): List<Word>? {
        return db?.read<MutableList<Word>>(Constants.TRANSLATIONS_FILE, mutableListOf())
    }

    fun getRandomWord(): Word? {
        val allWords = getAllWords()
        word = if (word == null && allWords?.isNotEmpty() == true) allWords.random() else word
        return word
    }

    fun saveWord(word: Word) {
        val allWords = db?.read<MutableList<Word>>(Constants.TRANSLATIONS_FILE, mutableListOf())
        allWords?.add(word)
        db?.write(Constants.TRANSLATIONS_FILE, allWords)
    }

    fun updateList(data: List<Word>) {
        db?.write(Constants.TRANSLATIONS_FILE, data)
    }

    fun setSelectedPosition(position: Int) {
        selectedPosition = position
    }

    fun getSelectedWord(): Word? {
        val allWords = getAllWords()
        return if (selectedPosition != null && allWords != null && allWords.size > selectedPosition!!) allWords[selectedPosition!!] else null
    }

    fun updateSelectedWord(word: Word) {
        val allWords = getAllWords()
        if (selectedPosition != null && !allWords.isNullOrEmpty()) {
            allWords[selectedPosition!!].name = word.name
            allWords[selectedPosition!!].meaning = word.meaning
            updateList(allWords)
        }
    }
}