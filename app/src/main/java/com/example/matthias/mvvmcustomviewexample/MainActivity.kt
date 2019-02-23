package com.example.matthias.mvvmcustomviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.matthias.mvvmcustomviewexample.custom.CustomViewState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customView.setLifecycleOwner(this)

        if (savedInstanceState != null) {
            val customViewInternalState = savedInstanceState.getParcelable<CustomViewState>(CUSTOM_VIEW_STATE)
            customViewInternalState.let { customView.setState(it) }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(CUSTOM_VIEW_STATE, customView.getState() )
        super.onSaveInstanceState(outState)
    }

    private companion object {
        const val CUSTOM_VIEW_STATE = "CUSTOM_VIEW_STATE"
    }
}
