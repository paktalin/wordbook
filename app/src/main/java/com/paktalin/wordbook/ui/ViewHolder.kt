package com.paktalin.wordbook.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_line.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val wordEt: EditText = itemView.word
    val translationEt: EditText = itemView.translation

    init {
//        wordEt.addTextChangedListener(MyTextWatcher())
//        translationEt.addTextChangedListener(MyTextWatcher())
    }
}