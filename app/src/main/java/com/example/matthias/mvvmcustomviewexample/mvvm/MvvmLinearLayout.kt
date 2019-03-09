package com.example.matthias.mvvmcustomviewexample.mvvm

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import android.widget.LinearLayout

abstract class MvvmLinearLayout<V: MvvmCustomViewState, T: MvvmCustomViewModel<V>>(
        context: Context,
        attributeSet: AttributeSet
): LinearLayout(context, attributeSet), MvvmCustomView<V, T> {
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val lifecycleOwner = context as? LifecycleOwner ?: throw LifecycleOwnerNotFoundException()
        onLifecycleOwnerAttached(lifecycleOwner)
    }

    override fun onSaveInstanceState() = MvvmCustomViewStateWrapper(super.onSaveInstanceState(), viewModel.state)

    @Suppress("UNCHECKED_CAST")
    override fun onRestoreInstanceState(state: Parcelable?) {
        if (state is MvvmCustomViewStateWrapper) {
            viewModel.state = state.state as V?
            super.onRestoreInstanceState(state.superState)
        }
    }
}