package com.example.notebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notebook.adapters.NoteBookAdapter
import com.example.notebook.models.NoteBook

class MainActivity : AppCompatActivity() {

    private var mAdapter: NoteBookAdapter? = null
    private var mListNoteBook = ArrayList<NoteBook> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
