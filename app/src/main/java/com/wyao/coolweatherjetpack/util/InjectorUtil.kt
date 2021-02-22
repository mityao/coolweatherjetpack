package com.wyao.coolweatherjetpack.util

import com.wyao.coolweatherjetpack.data.PlaceRepository
import com.wyao.coolweatherjetpack.data.WeatherRepository
import com.wyao.coolweatherjetpack.data.db.CoolWeatherDatabase
import com.wyao.coolweatherjetpack.data.network.CoolWeatherNetWork
import com.wyao.coolweatherjetpack.ui.MainModelFactory
import com.wyao.coolweatherjetpack.ui.area.ChooseAreaModelFactory
import com.wyao.coolweatherjetpack.ui.weather.WeatherModelFactory

object InjectorUtil {

    private fun getWeatherRepository() = WeatherRepository.getInstance(CoolWeatherDatabase.getWeatherDao(), CoolWeatherNetWork.getInstance())

    private fun getPlaceRepository() = PlaceRepository.getInstance(CoolWeatherDatabase.getPlaceDao(), CoolWeatherNetWork.getInstance())

    fun getWeatherModelFactory() = WeatherModelFactory(getWeatherRepository())

    fun getChooseAreaModelFactory() = ChooseAreaModelFactory(getPlaceRepository())

    fun getMainModelFactory() = MainModelFactory(getWeatherRepository())
}