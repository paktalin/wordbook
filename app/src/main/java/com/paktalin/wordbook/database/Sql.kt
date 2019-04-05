package com.paktalin.wordbook.database

import android.provider.BaseColumns
import com.paktalin.wordbook.database.DatabaseEntries.COLUMN_WORD
import com.paktalin.wordbook.database.DatabaseEntries.COLUMN_TRANSLATION
import com.paktalin.wordbook.database.DatabaseEntries.TABLE_NAME

const val SQL_CREATE_ENTRIES =
        "CREATE TABLE $TABLE_NAME (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "$COLUMN_WORD TEXT," +
                "$COLUMN_TRANSLATION TEXT)"

const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"
