package com.wyao.coolweatherjetpack.ui.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.wyao.coolweatherjetpack.R
import com.wyao.coolweatherjetpack.data.WeatherRepository

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        val viewModel = ViewModelProvider(this,
            WeatherModelFactory(WeatherRepository())).get(WeatherViewModel::class.java)
    }
}
