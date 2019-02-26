package com.example.matthias.mvvmcustomviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.matthias.mvvmcustomviewexample.custom.CustomViewState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
