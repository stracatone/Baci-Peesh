package com.wordgenerator.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wordgenerator.app.contracts.AddWordContract
import com.wordgenerator.app.R
import com.wordgenerator.app.presenter.AddWordPresenter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_write.*
import javax.inject.Inject

class AddWordFragment : DaggerFragment(), AddWordContract.View {

    @Inject
    lateinit var addWordPresenter: AddWordPresenter

    override fun showErrorMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT)
                .show()
    }

    override fun showSuccessMessage(message: String) {
        etAddWord?.text?.clear()
        etAddTranslation?.text?.clear()
        Toast.makeText(activity, message, Toast.LENGTH_SHORT)
                .show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_write, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnConfirm?.setOnClickListener {
            addWordPresenter.saveWord(etAddWord.text?.run { if (this.isNotEmpty()) this.toString() else "" },
                                      etAddTranslation?.text?.run { if (this.isNotEmpty()) this.toString() else "" })
        }
    }
}