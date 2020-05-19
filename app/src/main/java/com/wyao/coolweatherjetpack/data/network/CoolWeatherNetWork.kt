package com.wyao.coolweatherjetpack.data.network

import com.wyao.coolweatherjetpack.data.network.api.PlaceService
import com.wyao.coolweatherjetpack.data.network.api.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class CoolWeatherNetWork {

    private val placeService: PlaceService = ServiceCreator.create(PlaceService::class.java)

    private val weatherService: WeatherService = ServiceCreator.create(WeatherService::class.java)

    suspend fun fetchProvinceList() = placeService.getProvinces().await()

    suspend fun fetchCityList(provinceId: Int) = placeService.getCities(provinceId).await()

    suspend fun fetchWeather(weatherId: String) = weatherService.getWeather(weatherId).await()

    suspend fun fetchBingPic() = weatherService.getBingPic().await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
            })
        }
    }

    companion object {

        private var network: CoolWeatherNetWork? = null

        fun getInstance(): CoolWeatherNetWork {
            if (network == null) {
                synchronized(CoolWeatherNetWork::class.java) {
                    if (network == null) {
                        network = CoolWeatherNetWork()
                    }
                }
            }
            return network!!
        }
    }
}