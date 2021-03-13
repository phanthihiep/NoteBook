package com.example.notebook.adapters

<<<<<<< HEAD
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notebook.R
import com.example.notebook.interfaces.IOnClickItem
import com.example.notebook.models.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteBookAdapter(private var list: ArrayList<Note>, var mOnclickItem: IOnClickItem) :
    RecyclerView.Adapter<NoteBookAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(note: Note) {
            val count = note.content.length
            val layoutParams =
                itemView.layout_item_out.layoutParams
            if (count < 100) {
                layoutParams.height = 270
                itemView.layout_item_out.layoutParams = layoutParams
            } else {
                layoutParams.height = 400
                itemView.layout_item_out.layoutParams = layoutParams
            }

            itemView.img_bg.setImageResource(note.img)
            itemView.tv_title.text = note.title
            itemView.tv_content.text = note.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            mOnclickItem.onClickItem(list[position])
=======
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
>>>>>>> develop
        }
    }
}