package com.wordgenerator.app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.wordgenerator.app.R
import com.wordgenerator.app.model.Word

class WordsRecyclerViewAdapter(var values: List<Word>) : RecyclerView.Adapter<WordsRecyclerViewAdapter.ViewHolder>() {

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
        holder.swEnabled.isChecked = word.enabled == true
        holder.swEnabled.setOnCheckedChangeListener { _, isChecked ->
            values[position].enabled = isChecked
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvWord: TextView = view.findViewById(R.id.tvWord)
        val tvMeaning: TextView = view.findViewById(R.id.tvMeaning)
        val swEnabled: SwitchCompat = view.findViewById(R.id.swIncludeWord)

        override fun toString(): String {
            return super.toString() + " '" + tvMeaning.text + "'"
        }
    }
}