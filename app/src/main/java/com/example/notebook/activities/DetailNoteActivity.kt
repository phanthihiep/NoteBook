package com.example.notebook.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.notebook.BuildConfig
import com.example.notebook.R
import com.example.notebook.commons.Constants
import kotlinx.android.synthetic.main.activity_detail_note.*
import kotlinx.android.synthetic.main.layout_bottom_detail.*
import yuku.ambilwarna.AmbilWarnaDialog

class DetailNoteActivity : AppCompatActivity() {

    var mDefaultColor = Color.RED
    private var mImagePath: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_note)

        edt_content.requestFocus()
    }

    override fun onResume() {
        super.onResume()
        chooseColorText()
        chooseBackground()
        chooseFont()
        addImage()
        addCheckList()
    }

    private fun chooseColorText() {
        btn_color_text.setOnClickListener {
            val colorPicker =
                AmbilWarnaDialog(
                    this,
                    mDefaultColor,
                    object : AmbilWarnaDialog.OnAmbilWarnaListener {
                        override fun onCancel(dialog: AmbilWarnaDialog) {}
                        override fun onOk(dialog: AmbilWarnaDialog, color: Int) {
                            mDefaultColor = color
                            //set color
                        }
                    })
            colorPicker.show()
            setVisibleView(false)
        }

    }

    private fun chooseFont() {
        btn_font.setOnClickListener {
            Toast.makeText(this, "font", Toast.LENGTH_SHORT).show()
            setVisibleView(true)
        }
    }

    private fun chooseBackground() {
        btn_background.setOnClickListener {
            Toast.makeText(this, "background", Toast.LENGTH_SHORT).show()
            setVisibleView(true)
        }
    }

    private fun addImage() {
        btn_image.setOnClickListener {
            // API version <= 29
            if (allPermissionsGranted()) {
                openFolder()
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    Constants.REQUIRED_PERMISSIONS,
                    Constants.REQUEST_CODE_PERMISSIONS
                )
            }

            // request permission for API > 29
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.Q && !Environment.isExternalStorageManager()) {
                val uri = Uri.parse("package:${BuildConfig.APPLICATION_ID}")
                startActivity(Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION, uri))
            }
            setVisibleView(false)
        }
    }

    private fun addCheckList() {
        btn_list_check.setOnClickListener {
            Toast.makeText(this, "check", Toast.LENGTH_SHORT).show()
            setVisibleView(false)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && data != null) {
            mImagePath = data.data
            // img_load_avatar.setImageURI(mImagePath)
            Toast.makeText(this, "image: $mImagePath", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Method open folder select image
     */
    private fun openFolder() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        galleryIntent.type = "image/*"
        startActivityForResult(galleryIntent, 0)
    }

    /**
     * Method result permission request
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == Constants.REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                openFolder()
            } else {
                Toast.makeText(
                    this,
                    "Permissions not granted by the user.",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }

    /**
     * Check permission
     */
    private fun allPermissionsGranted() = Constants.REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(
            baseContext, it
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun setVisibleView(isVisible: Boolean) {
        if (isVisible) {
            layout_choose_style.visibility = View.VISIBLE
        } else {
            layout_choose_style.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        setVisibleView(false)
        super.onBackPressed()
    }
}