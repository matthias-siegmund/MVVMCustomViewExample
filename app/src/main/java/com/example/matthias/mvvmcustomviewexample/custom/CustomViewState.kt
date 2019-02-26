package com.example.matthias.mvvmcustomviewexample.custom

import com.example.matthias.mvvmcustomviewexample.mvvm.MvvmCustomViewState
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CustomViewState(
        val hexCode: String?
): MvvmCustomViewState