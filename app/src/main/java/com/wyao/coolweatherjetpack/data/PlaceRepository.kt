package com.wyao.coolweatherjetpack.data

import com.wyao.coolweatherjetpack.data.db.PlaceDao
import com.wyao.coolweatherjetpack.data.network.CoolWeatherNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlaceRepository private constructor(private val placeDao: PlaceDao, private val netWork: CoolWeatherNetWork) {

    suspend fun getProvinceList() = withContext(Dispatchers.IO) {
        var list = placeDao.getProvinceList()
        if (list.isEmpty()) {
            list = netWork.fetchProvinceList()
            placeDao.saveProvinceList(list)
        }
        list
    }

    suspend fun getCityList(provinceId: Int) = withContext(Dispatchers.IO) {
        var list = placeDao.getCityList(provinceId)
        if (list.isEmpty()) {
            list = netWork.fetchCityList(provinceId)
            list.forEach { it.provinceId = provinceId }
            placeDao.saveCityList(list)
        }
        list
    }

    suspend fun getCountyList(provinceId: Int, cityId: Int) = withContext(Dispatchers.IO) {
        var list = placeDao.getCountyList(cityId)
        if (list.isEmpty()) {
            list = netWork.fetchCountyList(provinceId, cityId)
            list.forEach { it.cityId = cityId }
            placeDao.saveCountyList(list)
        }
        list
    }

    companion object {

        private var instance: PlaceRepository? = null

        fun getInstance(placeDao: PlaceDao, netWork: CoolWeatherNetWork): PlaceRepository {
            if (instance == null) {
                synchronized(PlaceRepository::class.java) {
                    if (instance == null) {
                        instance = PlaceRepository(placeDao, netWork)
                    }
                }
            }
            return instance!!
        }
    }
}