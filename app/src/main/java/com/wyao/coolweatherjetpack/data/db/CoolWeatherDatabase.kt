package com.wyao.coolweatherjetpack.data.db

object CoolWeatherDatabase {

    private var weatherDao: WeatherDao? = null

    private var placeDao: PlaceDao? = null

    fun getWeatherDao(): WeatherDao {
        if (weatherDao == null) {
            weatherDao = WeatherDao()
        }
        return weatherDao!!
    }

    fun getPlaceDao(): PlaceDao {
        if (placeDao == null) {
            placeDao = PlaceDao()
        }
        return placeDao!!
    }
}