package com.example.notebook.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notebook.R
import com.example.notebook.interfaces.IOnClickItemNoteHome
import com.example.notebook.models.NoteBook
import kotlinx.android.synthetic.main.item_notebook.view.*

class NoteBookAdapter(private var listNote: ArrayList<NoteBook>, private var mIOnClickItem: IOnClickItemNoteHome) {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun onBind(note: NoteBook) {
            itemView.tv_title.text = note.title
            itemView.tv_content.text = note.content
            itemView.tv_date.text = note.date
        }
    }
}