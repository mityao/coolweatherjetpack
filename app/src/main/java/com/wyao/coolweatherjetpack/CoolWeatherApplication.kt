package com.wyao.coolweatherjetpack

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import org.litepal.LitePal

class CoolWeatherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        LitePal.initialize(this)
        mContext = this
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var mContext: Context
    }
}