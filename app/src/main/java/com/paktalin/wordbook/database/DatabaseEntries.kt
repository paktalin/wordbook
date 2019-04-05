package com.paktalin.wordbook.database

import android.provider.BaseColumns

object DatabaseEntries : BaseColumns {
    const val TABLE_NAME = "vocabulary"
    const val COLUMN_WORD = "word"
    const val COLUMN_TRANSLATION = "translation"
}