package com.wordgenerator.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wordgenerator.app.R
import com.wordgenerator.app.contracts.ListWordsContract
import com.wordgenerator.app.adapters.WordsRecyclerViewAdapter
import com.wordgenerator.app.model.Word
import com.wordgenerator.app.presenter.ListWordsPresenter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_words_list.*
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 */
class ListWordsFragment : DaggerFragment(), ListWordsContract.View {

    @Inject
    lateinit var presenter: ListWordsPresenter

    @Inject
    lateinit var adapter: WordsRecyclerViewAdapter

    override fun updateWordsList(data: List<Word>?) {
        if (data.isNullOrEmpty()) {
            // show empty view
            if (switcher.nextView.id == R.id.tvEmptyList) {
                switcher.showNext()
            }
        } else {
            // show list
            if (switcher.nextView.id == R.id.rvWords) {
                switcher.showNext()
            }
            // update list
            adapter.setData(data)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_words_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // set list
        rvWords?.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.getWordsToShow()
    }
}