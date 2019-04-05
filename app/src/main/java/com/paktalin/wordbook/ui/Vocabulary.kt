package com.paktalin.wordbook.ui

class Vocabulary: Iterable<Entry>{

    val entries = mutableListOf(Entry("", ""))

    fun add(word: String, translation: String, id: Long) {
        entries.add(Entry(word, translation, id))
    }

    fun size(): Int {
        return entries.size
    }

    fun updateWord(position: Int, word: String) {
        entries[position].word = word
    }

    fun updateTranslation(position: Int, translation: String) {
        entries[position].translation = translation
    }

    fun print() {
        for (entry in this) entry.print()
    }

    override fun iterator(): Iterator<Entry> {
        return entries.iterator()
    }

    operator fun get(position: Int): Entry {
        return entries[position]
    }
}