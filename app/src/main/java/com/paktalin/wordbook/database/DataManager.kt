package com.paktalin.wordbook.database

import android.content.ContentValues
import android.provider.BaseColumns._ID
import com.paktalin.wordbook.database.DatabaseEntries.COLUMN_TRANSLATION
import com.paktalin.wordbook.database.DatabaseEntries.COLUMN_WORD
import com.paktalin.wordbook.database.DatabaseEntries.TABLE_NAME
import com.paktalin.wordbook.log
import com.paktalin.wordbook.ui.Vocabulary

class DataManager {
    companion object {
        fun loadVocabulary(dbHelper: DatabaseHelper): Vocabulary {
            val db = dbHelper.readableDatabase
            val cursor = db.query(TABLE_NAME, arrayOf(COLUMN_WORD, COLUMN_TRANSLATION, _ID), null, null, null, null, null)
            val vocabulary = Vocabulary()
            with(cursor) {
                while (moveToNext()) {
                    val word = getString(getColumnIndexOrThrow(COLUMN_WORD))
                    val translation = getString(getColumnIndexOrThrow(COLUMN_TRANSLATION))
                    val id = getLong(getColumnIndexOrThrow(_ID))
                    vocabulary.add(word, translation, id)
                }
            }
            cursor.close()
            vocabulary.print()
            return vocabulary
        }

        fun updateVocabulary(dbHelper: DatabaseHelper, vocabulary: Vocabulary, updatedPositions: MutableSet<Int>) {
            val db = dbHelper.writableDatabase
            for (i in updatedPositions) {
                val values = ContentValues().apply {
                    put(COLUMN_WORD, vocabulary[i].word)
                    put(COLUMN_TRANSLATION, vocabulary[i].translation)
                }
                if (vocabulary[i].id != (-1).toLong())
                    db?.update(TABLE_NAME, values, "$_ID=${vocabulary[i].id}", null)
                else
                    log(db?.insert(TABLE_NAME, null, values).toString())
            }
            loadVocabulary(dbHelper)
        }
    }
}
