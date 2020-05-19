package com.wyao.coolweatherjetpack.util

import com.wyao.coolweatherjetpack.data.WeatherRepository
import com.wyao.coolweatherjetpack.data.db.CoolWeatherDatabase
import com.wyao.coolweatherjetpack.data.network.CoolWeatherNetWork
import com.wyao.coolweatherjetpack.ui.weather.WeatherModelFactory

object InjectorUtil {

    private fun getWeatherRepository() = WeatherRepository.getInstance(CoolWeatherDatabase.getWeatherDao(), CoolWeatherNetWork.getInstance())

    fun getWeatherModelFactory() = WeatherModelFactory(getWeatherRepository())
}