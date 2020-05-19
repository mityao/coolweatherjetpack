package com.wyao.coolweatherjetpack.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wyao.coolweatherjetpack.data.WeatherRepository
import com.wyao.coolweatherjetpack.data.model.weather.Weather

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    var weather = MutableLiveData<Weather>()

    var bingPicUrl = MutableLiveData<String>()

    var weatherInitialized = MutableLiveData<Boolean>()

    fun getWeather() {

    }

    fun refreshWeather() {}

}