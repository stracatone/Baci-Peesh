package com.wordgenerator.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wordgenerator.app.R
import com.wordgenerator.app.contracts.EditWordContract
import com.wordgenerator.app.model.Word
import com.wordgenerator.app.presenter.EditWordPresenter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_write.*
import javax.inject.Inject

class EditWordFragment : DaggerFragment(), EditWordContract.View {

    @Inject
    lateinit var presenter: EditWordPresenter

    override fun showSelectedWord(word: Word?) {
        etAddWord?.setText(word?.name ?: "")
        etAddTranslation?.setText(word?.meaning ?: "")
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT)
                .show()
    }

    override fun showSuccessMessage(message: String) {
        activity?.onBackPressed()
        Toast.makeText(activity, message, Toast.LENGTH_SHORT)
                .show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_write, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getSelectedWord()

        btnConfirm?.setOnClickListener {
            presenter.saveWord(etAddWord.text?.run { if (this.isNotEmpty()) this.toString() else "" },
                               etAddTranslation?.text?.run { if (this.isNotEmpty()) this.toString() else "" })
        }
    }
}