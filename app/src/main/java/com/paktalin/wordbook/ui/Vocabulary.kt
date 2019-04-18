package com.paktalin.wordbook.ui

import com.paktalin.wordbook.log
import java.lang.IndexOutOfBoundsException

class Vocabulary: Iterable<Entry>{

    val entries = mutableListOf<Entry>()

    fun add(word: String, translation: String, id: Long) {
        entries.add(Entry(word, translation, id))
    }

    fun remove(position: Int) {
        entries.removeAt(position)
        log("removed from $position")
    }

    fun size(): Int {
        return entries.size
    }

    fun updateWord(position: Int, word: String) {
        try {
            entries[position].word = word
        } catch (ignored : IndexOutOfBoundsException){}
    }

    fun updateTranslation(position: Int, translation: String) {
        entries[position].translation = translation
    }

    fun print() {
        for (entry in this)
            entry.print(entries.indexOf(entry))
    }

    override fun iterator(): Iterator<Entry> {
        return entries.iterator()
    }

    operator fun get(position: Int): Entry {
        return entries[position]
    }
}