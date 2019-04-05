package com.paktalin.wordbook.ui

import android.content.ContentValues
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.paktalin.wordbook.R
import com.paktalin.wordbook.database.DataManager.Companion.loadVocabulary
import com.paktalin.wordbook.database.DatabaseHelper
import kotlinx.android.synthetic.main.activity_main.*
import com.paktalin.wordbook.database.DatabaseEntries.COLUMN_TRANSLATION
import com.paktalin.wordbook.database.DatabaseEntries.COLUMN_WORD
import com.paktalin.wordbook.database.DatabaseEntries.TABLE_NAME

class MainActivity : AppCompatActivity() {
    lateinit var vocabulary: Vocabulary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vocabulary = loadVocabulary(DatabaseHelper(this@MainActivity))
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = VocabularyAdapter(vocabulary)
        }
    }

    fun fillDb() {
        val dbHelper = DatabaseHelper(this@MainActivity)
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_WORD, "ragazzo")
            put(COLUMN_TRANSLATION, "boy")
        }
        db?.insert(TABLE_NAME, null, values)
    }
}
