package com.wordgenerator.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.wordgenerator.app.R
import com.wordgenerator.app.adapters.WordsRecyclerViewAdapter
import com.wordgenerator.app.contracts.ListWordsContract
import com.wordgenerator.app.model.Word
import com.wordgenerator.app.presenter.ListWordsPresenter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_words_list.*
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 */
class ListWordsFragment : DaggerFragment(), ListWordsContract.View {

    private var interstitialAd: InterstitialAd? = null

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

    override fun openDetails(position: Int) {
        presenter.setSelected(position)
        findNavController().navigate(R.id.actionGoToEditWord)
    }

    override fun shouldShowAdd(shouldShowAdd: Boolean) {
        if (shouldShowAdd) {
            interstitialAd?.show()
            presenter.saveAddStatus()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_words_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // set list
        rvWords?.adapter = adapter
        // add details page listener
        adapter.navigationListener = this::openDetails
        // ads
        interstitialAd = InterstitialAd(activity)
        interstitialAd?.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        interstitialAd?.loadAd(AdRequest.Builder()
                                      .build())
        interstitialAd?.adListener = object : AdListener() {
            override fun onAdLoaded() {
                presenter.checkAddStatus()
            }

            override fun onAdFailedToLoad(errorCode: Int) {
                // do nothing
            }

            override fun onAdOpened() {
                // do nothing
            }

            override fun onAdClicked() {
                // do nothing
            }

            override fun onAdLeftApplication() {
                // do nothing
            }

            override fun onAdClosed() {
                // do nothing
            }
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.getWordsToShow()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (!adapter.values.isNullOrEmpty()) {
            presenter.saveData(adapter.values)
        }
    }
}