package com.wordgenerator.app.dummy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wordgenerator.app.R
import com.wordgenerator.app.dummy.DummyContent.DummyItem
import com.wordgenerator.app.model.Word

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class WordsRecyclerViewAdapter(private var values: List<Word>) : RecyclerView.Adapter<WordsRecyclerViewAdapter.ViewHolder>() {

    fun setData(values: List<Word>) {
        this.values = values
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_words, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val word = values[position]
        holder.tvWord.text = word.name
        holder.tvMeaning.text = word.meaning
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvWord: TextView = view.findViewById(R.id.tvWord)
        val tvMeaning: TextView = view.findViewById(R.id.tvMeaning)

        override fun toString(): String {
            return super.toString() + " '" + tvMeaning.text + "'"
        }
    }
}