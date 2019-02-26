package com.example.matthias.mvvmcustomviewexample.custom

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import com.example.matthias.mvvmcustomviewexample.R
import com.example.matthias.mvvmcustomviewexample.mvvm.MvvmLinearLayout
import kotlinx.android.synthetic.main.custom_view.view.*

class CustomView(
        context: Context,
        attrs: AttributeSet
): MvvmLinearLayout<CustomViewState, CustomViewModel>(context, attrs) {
    init {
        View.inflate(context, R.layout.custom_view, this)
        redButton.setOnClickListener { viewModel.onRedButtonClick() }
        blueButton.setOnClickListener { viewModel.onBlueButtonClick() }
    }

    override val viewModel = CustomViewModel()

    override fun onLifecycleOwnerAttached(lifecycleOwner: LifecycleOwner) {
        observeLiveData(lifecycleOwner)
    }

    private fun observeLiveData(lifecycleOwner: LifecycleOwner) {
        viewModel.getLiveData().observe(lifecycleOwner, Observer {
            setBackgroundColor(Color.parseColor(it))
        })
    }
}