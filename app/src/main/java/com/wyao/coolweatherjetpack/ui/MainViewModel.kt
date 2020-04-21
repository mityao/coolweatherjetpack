package com.wyao.coolweatherjetpack.ui

import androidx.lifecycle.ViewModel
import com.wyao.coolweatherjetpack.data.WeatherRepository

class MainViewModel(private val repository: WeatherRepository) : ViewModel(){

    fun isWeatherCached() = repository.isWeatherCached()
}