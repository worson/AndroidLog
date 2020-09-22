package app.worson.simplelog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.worson.lib.log.L

class MainActivity : AppCompatActivity() {

    val  TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        L.init(Log.VERBOSE)
        L.i(TAG, "onCreate: ")

    }
}