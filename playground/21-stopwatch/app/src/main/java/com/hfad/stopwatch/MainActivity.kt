package com.hfad.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    lateinit var stopWatch: Chronometer
    var running = false
    var offset: Long = 0

    // key strings for use with the Bundle
    val OFFSET_KEY = "offset"
    val RUNNING_KEY = "running"
    val BASE_KEY = "base"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get a reference to the stopwatch
        stopWatch = findViewById(R.id.stopwatch)

        // Restore the previous state
        if (savedInstanceState != null) {
            offset = savedInstanceState.getLong(OFFSET_KEY)
            running = savedInstanceState.getBoolean(RUNNING_KEY)
            if (running) {
                stopWatch.base = savedInstanceState.getLong(BASE_KEY)
                stopWatch.start()
            } else setBaseTime()
        }

        // The start button
        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener {
            if (!running) {
                setBaseTime()
                stopWatch.start()
                running = true
            }
        }

        // The pause button
        val pauseButton = findViewById<Button>(R.id.pause_button)
        pauseButton.setOnClickListener {
            if (running) {
                saveOffset()
                stopWatch.stop()
                running = false
            }
        }

        // The reset button
        val resetButton = findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener {
            offset = 0
            setBaseTime()
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.putLong(OFFSET_KEY, offset)
        savedInstanceState.putBoolean(RUNNING_KEY, running)
        savedInstanceState.putLong(BASE_KEY, stopWatch.base)
        super.onSaveInstanceState(savedInstanceState)
    }

    // override fun onStop() {
        // super.onStop()
    override fun onPause() {
        super.onPause()
        if (running) {
            saveOffset()
            stopWatch.stop()
        }
    }

    // override fun onRestart() {
        // super.onRestart()
    override fun onResume() {
        super.onResume()
        if (running) {
            setBaseTime()
            stopWatch.start()
            offset = 0
        }
    }

    fun setBaseTime() {
        stopWatch.base = SystemClock.elapsedRealtime() - offset
    }

    fun saveOffset() {
        offset = SystemClock.elapsedRealtime() - stopWatch.base
    }
}