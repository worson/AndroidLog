package com.worson.simplelog;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.worson.lib.log.L;

import app.worson.simplelog.R;


public class MainJavaActivity extends AppCompatActivity {

    private final static String TAG = "MainJavaActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_java);
        L.init(Log.VERBOSE);
        L.setStackTrace(true,5);
        L.i(TAG, "onCreate: 1");
        L.d(TAG, "onCreate: 2");
    }
}