package com.hfad.findme

import android.app.Dialog
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dialog = createInstructionsDialog()
        dialog.show()
    }

    private fun createInstructionsDialog(): Dialog {
        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.drawable.android)
            .setTitle(R.string.instructions_title)
            .setMessage(R.string.instructions)
            .setPositiveButtonIcon(ContextCompat.getDrawable(this, android.R.drawable.ic_media_play))
        return builder.create()
    }
}