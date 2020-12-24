package com.example.manage_study.ui.notifications

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

const val DB_NAME = "mydb.db"
const val TABLE_NAME = "todolist"

class SqLiteHelper(context: Context, version:Int) : SQLiteOpenHelper (context, DB_NAME,null,version){

    private val createBook = "create table todolist(" +
            " id integer primary key autoincrement," +
            "name text)"
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createBook)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }


}