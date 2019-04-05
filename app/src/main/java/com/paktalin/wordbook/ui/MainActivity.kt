package com.paktalin.wordbook.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.paktalin.wordbook.R
import com.paktalin.wordbook.database.DataManager.Companion.loadVocabulary
import com.paktalin.wordbook.database.DataManager.Companion.updateVocabulary
import com.paktalin.wordbook.database.DatabaseHelper
import com.paktalin.wordbook.log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val dbHelper = DatabaseHelper(this@MainActivity)
    private lateinit var adapter: VocabularyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val vocabulary = loadVocabulary(dbHelper)
        adapter = VocabularyAdapter(vocabulary)
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    override fun onPause() {
        super.onPause()
        updateVocabulary(dbHelper, adapter.vocabulary, adapter.updatedPositions)
    }
}
