package com.paktalin.wordbook.database

import android.provider.BaseColumns._ID
import com.paktalin.wordbook.ui.Vocabulary

class DataManager {
    companion object {
        fun loadVocabulary(dbHelper: DatabaseHelper): Vocabulary {
            val db = dbHelper.writableDatabase
            val cursor = db.query(DatabaseEntries.TABLE_NAME, arrayOf(DatabaseEntries.COLUMN_WORD, DatabaseEntries.COLUMN_TRANSLATION), null, null, null, null, null)
            val vocabulary = Vocabulary()
            with(cursor) {
                while (moveToNext()) {
                    val word = getString(getColumnIndexOrThrow(DatabaseEntries.COLUMN_WORD))
                    val translation = getString(getColumnIndexOrThrow(DatabaseEntries.COLUMN_TRANSLATION))
                    val id = getLong(getColumnIndexOrThrow(_ID))
                    vocabulary.add(word, translation, id)
                }
            }
            cursor.close()
            return vocabulary
        }

//        fun replaceEntry()
    }
}
