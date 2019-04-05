package com.paktalin.wordbook.ui

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import com.paktalin.wordbook.R
import com.paktalin.wordbook.database.DatabaseEntries.COLUMN_TRANSLATION
import com.paktalin.wordbook.database.DatabaseEntries.COLUMN_WORD

class VocabularyAdapter(val vocabulary: Vocabulary) : RecyclerView.Adapter<ViewHolder>() {
    var updatedPositions = mutableSetOf<Int>()

    override fun getItemCount(): Int {
        return vocabulary.size()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.wordEt.setText(vocabulary[position].word)
        holder.translationEt.setText(vocabulary[position].translation)
        holder.wordEt.addTextChangedListener(MyTextWatcher(position, COLUMN_WORD))
        holder.translationEt.addTextChangedListener(MyTextWatcher(position, COLUMN_TRANSLATION))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_line, parent, false)
        return ViewHolder(view)
    }

    inner class MyTextWatcher(private val position: Int, private val column: String) : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            val updatedField = editable?.toString()
            if (updatedField != null) {
                if (column == COLUMN_WORD) vocabulary.updateWord(position, updatedField)
                else vocabulary.updateTranslation(position, updatedField)
                updatedPositions.add(position)
            }
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

}