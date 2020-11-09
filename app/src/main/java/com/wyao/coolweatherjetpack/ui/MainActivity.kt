package com.wyao.coolweatherjetpack.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.wyao.coolweatherjetpack.R
import com.wyao.coolweatherjetpack.data.WeatherRepository
import com.wyao.coolweatherjetpack.ui.area.ChooseAreaFragment
import com.wyao.coolweatherjetpack.ui.weather.WeatherActivity
import com.wyao.coolweatherjetpack.util.InjectorUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this, InjectorUtil.getMainModelFactory()).get(MainViewModel::class.java)
        if (viewModel.isWeatherCached()) {
            val intent = Intent(this, WeatherActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.container, ChooseAreaFragment()).commit()
        }
    }
}
