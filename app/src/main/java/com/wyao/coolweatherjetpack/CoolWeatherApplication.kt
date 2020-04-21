package com.wyao.coolweatherjetpack

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class CoolWeatherApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var mContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }
}