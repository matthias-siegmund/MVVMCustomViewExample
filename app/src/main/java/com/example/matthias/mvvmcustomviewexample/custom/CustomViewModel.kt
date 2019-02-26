package com.example.matthias.mvvmcustomviewexample.custom

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.matthias.mvvmcustomviewexample.mvvm.MvvmCustomViewModel

class CustomViewModel: MvvmCustomViewModel<CustomViewState> {
    private val liveData = MutableLiveData<String?>()

    override var state: CustomViewState? = null
        get() = CustomViewState(liveData.value)
        set(value) {
            field = value
            restore(value)
        }

    fun getLiveData(): LiveData<String?> = liveData

    fun onRedButtonClick() {
        liveData.value = "#FF0000"
    }

    fun onBlueButtonClick() {
        liveData.value = "#0000FF"
    }

    private fun restore(state: CustomViewState?) {
        liveData.value = state?.hexCode
    }
}