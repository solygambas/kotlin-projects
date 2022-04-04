package com.hfad.guessinggame

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModel

class ResultViewModel(finalResult: String): ViewModel() {
    val result = finalResult

    fun shareResult() : Intent {
        val myResult = result.replace("You", "I")
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, myResult)
            type = "text/plain"
        }
        return Intent.createChooser(sendIntent, null)
    }
}