package com.example.notebook.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class NoteBook(val title:String, val content: String, val date: String) : Parcelable