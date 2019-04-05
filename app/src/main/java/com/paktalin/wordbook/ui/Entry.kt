package com.paktalin.wordbook.ui

import com.paktalin.wordbook.log

class Entry(var word: String,  var translation: String) {
    var id: Long = -1

    constructor(word: String, translation: String, id: Long) : this(word, translation) {
        this.id = id
    }

    fun print() {
        log("$word - $translation - $id")
    }
}
