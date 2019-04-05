package com.paktalin.wordbook.ui

import android.text.Editable
import android.text.TextWatcher
import com.paktalin.wordbook.log

class MyTextWatcher(private val position: Int) : TextWatcher {
    override fun afterTextChanged(editable: Editable?) {
        log("$position")
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }
}