package com.paktalin.wordbook.ui

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import com.paktalin.wordbook.R

class VocabularyAdapter(val vocabulary: Vocabulary) : RecyclerView.Adapter<ViewHolder>() {
    var deletedIds = mutableSetOf<Long>()
    var updatedEntries = mutableSetOf<Entry>()

    override fun getItemCount(): Int {
        return vocabulary.size()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.wordEt.setText(vocabulary[position].word)
        holder.translationEt.setText(vocabulary[position].translation)
        holder.wordEt.addTextChangedListener(MyTextWatcher(position) {
            v, p -> vocabulary.updateWord(p, v)} )
        holder.translationEt.addTextChangedListener(MyTextWatcher(position) {
            v, p -> vocabulary.updateTranslation(p, v)})
        holder.entryLayout.setOnLongClickListener {
            vocabulary.remove(position)
            this@VocabularyAdapter.notifyItemRemoved(position)
            this@VocabularyAdapter.notifyDataSetChanged()
            deletedIds.add(vocabulary[position].id)
            // TODO(solve the problem with indexOutOfBounds)
            true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_entry, parent, false)
        return ViewHolder(view)
    }

    inner class MyTextWatcher(private val position: Int, val update: (value: String, position: Int) -> Unit) : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            update(editable?.toString()!!, position)
            updatedEntries.add(vocabulary[position])
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }

}