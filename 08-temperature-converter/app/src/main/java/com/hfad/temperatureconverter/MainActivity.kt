package com.hfad.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Hello("friend")
                Hello("everyone")
            }
        }
    }

    @Composable
    fun Hello(name: String) {
        Text("Hello $name! Welcome to Jetpack Compose")
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewMainActivity() {
        Column {
            Hello("friend")
            Hello("everyone")
        }
    }
}