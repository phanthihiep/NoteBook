package com.example.notebook.commons

import android.Manifest
import android.net.Uri

class Constants {
    companion object {
        const val REQUEST_CODE_PERMISSIONS = 10
        val REQUIRED_PERMISSIONS =
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
    }
}