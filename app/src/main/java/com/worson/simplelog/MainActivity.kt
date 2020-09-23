package com.worson.simplelog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.worson.simplelog.R
import com.worson.lib.log.L

class MainActivity : AppCompatActivity() {

    val  TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        L.init(Log.VERBOSE)
        L.setStackTrace(true)
        L.i(TAG, "onCreate: ")
        L.d(TAG) {"onCreate: "}

    }
}