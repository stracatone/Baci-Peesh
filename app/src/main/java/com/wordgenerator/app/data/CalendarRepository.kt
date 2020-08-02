package com.wordgenerator.app.data

import com.wordgenerator.app.util.Constants
import io.paperdb.Book
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CalendarRepository @Inject constructor(private val db: Book?) {

    fun saveLastDayFullAddShowed(dayOfYear: Int) {
        db?.write<Int>(Constants.DAY_IN_YEAR_FILE, dayOfYear)
    }

    fun getLastDayFullAddShowed(): Int? {
        return db?.read<Int>(Constants.DAY_IN_YEAR_FILE)
    }
}