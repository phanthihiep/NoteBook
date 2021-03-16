package com.example.notebook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notebook.activities.DetailNoteActivity
import com.example.notebook.adapters.NoteBookAdapter
import com.example.notebook.interfaces.IOnClickItem
import com.example.notebook.models.Note
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

class MainActivity : AppCompatActivity(), IOnClickItem {

    private var mAdapter: NoteBookAdapter? = null
    private var mListNote = ArrayList<Note>()
    private var isShowStagger = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(tool_bar)
        addData()
        setAdapter()
        addNewNote()
    }

    /**
     * Method set adapter
     */
    private fun setAdapter() {
        mAdapter = NoteBookAdapter(mListNote, this)
        if (!isShowStagger) {
            val layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            recycle_view_home.layoutManager = layoutManager
        } else {
            val layoutManager = LinearLayoutManager(this)
            recycle_view_home.layoutManager = layoutManager
        }
        recycle_view_home.adapter = mAdapter
    }

    /**
     * Method click add new note
     */
    private fun addNewNote() {
        fab_home.setOnClickListener {
            val intent = Intent(this, DetailNoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addData() {
        mListNote.add(
            Note(
                1,
                "1 study english and korean",
                "study english and korean study english and korean study english and korean study english and korean study english and korean" +
                        "study english and korean",
                R.drawable.bg_5
            )
        )
        mListNote.add(Note(2, "2", "study english and korean", R.drawable.bg_2))
        mListNote.add(
            Note(
                3,
                "3",
                "study english and korean study english and korean study english and korean study english and korean study english and korean" +
                        "study english and korean",
                R.drawable.bg_4
            )
        )
        mListNote.add(Note(4, "4", "study english and korean", R.drawable.bg_7))
        mListNote.add(
            Note(
                5,
                "5",
                "study english and korean study english and korean study english and korean study english and korean study english and korean study english and korean",
                R.drawable.bg_8
            )
        )
        mListNote.add(
            Note(
                6,
                "6 study english and korean",
                "study english and korean study english and korean study english and korean study " +
                        "study english and korean " +
                        "study english and korean english and korean study english and korean",
                R.drawable.bg_9
            )
        )
        mListNote.add(Note(2, "7", "study english and korean", R.drawable.bg_10))
        mListNote.add(
            Note(
                3,
                "8",
                "study english and korean study english and korean study english and korean study english and korean study english and korean" +
                        "study english and korean",
                R.drawable.bg_11
            )
        )
        mListNote.add(
            Note(
                4,
                "9",
                "study english and korean study english and korean study english and korean study english and korean study english and korean",
                R.drawable.bg_12
            )
        )
        mListNote.add(Note(5, "10", "study english and korean", R.drawable.bg_13))
        mListNote.add(
            Note(
                1,
                "11",
                "study english and korean study english and korean study english and korean study english and korean study english and korean" +
                        "study english and korean",
                R.drawable.bg_6
            )
        )
        mListNote.add(Note(2, "12", "study english and korean", R.drawable.bg_2))
        mListNote.add(
            Note(
                3,
                "13",
                "study english and korean study english and korean study english and korean study english and korean study english and korean" +
                        "study english and korean",
                R.drawable.bg_4
            )
        )
    }

    override fun onClickItem(note: Note) {
        TODO("Not yet implemented")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_item_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.show -> {
                isShowStagger = !isShowStagger
                setAdapter()
            }
            R.id.setting -> Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
