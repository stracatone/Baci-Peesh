package com.wordgenerator.app.data

import com.wordgenerator.app.model.Word
import com.wordgenerator.app.util.Constants
import io.paperdb.Book
import javax.inject.Inject

class WordsRepository @Inject constructor(private val db: Book?) {

    var word: Word? = null

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
}