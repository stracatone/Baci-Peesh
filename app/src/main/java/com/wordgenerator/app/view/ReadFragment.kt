package com.wordgenerator.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.ads.AdRequest
import com.wordgenerator.app.R
import com.wordgenerator.app.contracts.ReadWordContract
import com.wordgenerator.app.presenter.ReadWordPresenter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.card_back.*
import kotlinx.android.synthetic.main.fragment_read.*
import javax.inject.Inject

class ReadFragment : DaggerFragment(), ReadWordContract.View {

    @Inject
    lateinit var readWordPresenter: ReadWordPresenter

    override fun showTodayWord(word: String) {
        tvWord.text = word
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adRequest = AdRequest.Builder().build()
        avBanner1.loadAd(adRequest)
        readWordPresenter.getRandomWord()
    }
}