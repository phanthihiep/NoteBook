package com.example.notebook.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Note(val id: Int, val title: String, val content: String, val img: Int): Parcelable