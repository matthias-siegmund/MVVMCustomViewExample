package com.example.matthias.mvvmcustomviewexample.custom

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.example.matthias.mvvmcustomviewexample.R
import com.example.matthias.mvvmcustomviewexample.mvvm.MvvmCustomView
import kotlinx.android.synthetic.main.custom_view.view.*

class CustomView(
        context: Context,
        attrs: AttributeSet
): LinearLayout(context, attrs), MvvmCustomView<CustomViewState, CustomViewModel> {
    init {
        View.inflate(context, R.layout.custom_view, this)
        button.setOnClickListener { viewModel.onButtonClick() }
    }

    override val viewModel = CustomViewModel()

    override fun setLifecycleOwner(lifecycleOwner: LifecycleOwner) {
        observeLiveData(lifecycleOwner)
    }

    private fun observeLiveData(lifecycleOwner: LifecycleOwner) {
        viewModel.getLiveData().observe(lifecycleOwner, Observer {
            textView.text = it
        })
    }
}