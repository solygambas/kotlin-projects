package com.hfad.guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/*import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // test compose navigation
        /*setContent {
            MaterialTheme {
                Surface {
                    MainActivityContent()
                }
            }
        }*/
    }

   /* @Composable
    fun ScreenOne(navController: NavController) {
        Button(onClick = { navController.navigate("two") }) {
            Text("Navigate to Screen 2")
        }
    }

    @Composable
    fun ScreenTwo() {
        Text("This is a screen two")
    }

    @Composable
    fun MainActivityContent() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "one") {
            composable("one") { ScreenOne(navController) }
            composable("two") { ScreenTwo() }
        }
    }*/
}