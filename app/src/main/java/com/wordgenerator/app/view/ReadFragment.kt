package com.wordgenerator.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wordgenerator.app.R
import com.wordgenerator.app.ReadWordContract
import com.wordgenerator.app.WordsRepository
import com.wordgenerator.app.presenter.ReadWordPresenter
import io.paperdb.Paper
import kotlinx.android.synthetic.main.card_back.*

class ReadFragment : Fragment(), ReadWordContract.View {

    private var readWordPresenter: ReadWordPresenter? = null

    override fun showTodayWord(word: String) {
        tvWord.text = word
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Paper.init(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // init presenter
        val repo = WordsRepository(Paper.book())
        readWordPresenter = ReadWordPresenter(this, repo)
        readWordPresenter?.getRandomWord()
    }
}