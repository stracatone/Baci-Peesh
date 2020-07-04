package com.wordgenerator.app

import com.wordgenerator.app.model.Word
import io.paperdb.Book

class WordsRepository(private val db: Book?) {

    fun getRandomWord(): Word? {
        val allWords = db?.read<MutableList<Word>>("translations", mutableListOf())
        return allWords?.random()
    }

    fun saveWord(word: Word) {
        val allWords = db?.read<MutableList<Word>>("translations", mutableListOf())
        allWords?.add(word)
        db?.write("translations", allWords)
    }
}