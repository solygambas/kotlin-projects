package com.hfad.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*Column {
                Hello("friend")
                Hello("everyone")
            }*/
            MaterialTheme {
                Surface {
                    MainActivityContent()
                }
            }
        }
    }

    /*@Composable
    fun Hello(name: String) {
        Text("Hello $name! Welcome to Jetpack Compose")
    }*/

    @Composable
    fun Header(image: Int, description: String) {
        Image (
            painter = painterResource(image),
            contentDescription = description,
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }

    @Composable
    fun TemperatureText(celsius: Int) {
        val fahrenheit = (celsius.toDouble()*9/5)+32
        Text("$celsius Celsius is $fahrenheit Fahrenheit")
    }

    @Composable
    fun ConvertButton(clicked: () -> Unit) {
        Button(onClick = clicked) {
            Text("Convert")
        }
    }

    @Composable
    fun EnterTemperature(temperature: String, changed: (String) -> Unit) {
        TextField(
            value = temperature,
            onValueChange = changed,
            label = { Text("Enter a temperature in Celsius") },
            modifier = Modifier.fillMaxWidth()
        )
    }

    @Composable
    fun MainActivityContent() {
        val celsius = remember { mutableStateOf(0) }
        val newCelsius = remember { mutableStateOf("") }

        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            Header(R.drawable.sunrise, "sunrise image")
            EnterTemperature(newCelsius.value) { newCelsius.value = it }
            Row(modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
                ConvertButton {
                    newCelsius.value.toIntOrNull()?.let {
                        celsius.value = it
                    }
                }
            }
            TemperatureText(celsius.value)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewMainActivity() {
        /*Column {
            Hello("friend")
            Hello("everyone")
        }*/
        MaterialTheme {
            Surface {
                MainActivityContent()
            }
        }
    }
}