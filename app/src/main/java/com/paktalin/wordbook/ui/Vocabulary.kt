package com.paktalin.wordbook.ui

class Vocabulary: Iterable<Entry>{

    val entries = mutableListOf(Entry("", ""))

    fun add(word: String, translation: String, id: Long) {
        entries.add(Entry(word, translation, id))
    }

    fun size(): Int {
        return entries.size
    }

    override fun iterator(): Iterator<Entry> {
        return entries.iterator()
    }

    operator fun get(position: Int): Entry {
        return entries[position]
    }
}