package com.paktalin.wordbook.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.paktalin.wordbook.R

class VocabularyAdapter(private val vocabulary: Vocabulary) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return vocabulary.size()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.wordEt.setText(vocabulary[position].word)
        holder.translationEt.setText(vocabulary[position].translation)
        holder.wordEt.addTextChangedListener(MyTextWatcher(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_line, parent, false)
        return ViewHolder(view)
    }

}