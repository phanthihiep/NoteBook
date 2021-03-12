package com.example.notebook.interfaces

import com.example.notebook.models.Note

interface IOnClickItem {
    fun onClickItem(note: Note)
}