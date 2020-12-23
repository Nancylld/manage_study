package com.example.manage_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.example.weather_app.weather.Forecast
import com.example.weather_app.weather.Weather
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main2.*
import com.android.volley.toolbox.Volley
import com.android.volley.toolbox.StringRequest

class MainActivity2 : AppCompatActivity() {
    val baseURL = "http://t.weather.itboy.net/api/weather/city/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val cityCode= intent.getStringExtra("city_code")
        val queue=Volley.newRequestQueue(this)
        val stringRequest = StringRequest(baseURL+cityCode,{
            val gson = Gson()
            val WeatherType = object : TypeToken<Weather>() {}.type
            val weather = gson.fromJson<Weather>(it,WeatherType)
            city.text = weather.cityInfo.city
            province.text = weather.cityInfo.parent
            wendu.text = "温度："+weather.data.wendu
            shidu.text = "湿度："+weather.data.shidu
            val firstDay = weather.data.forecast.first()
            when(firstDay.type){
                "晴" -> imageView.setImageResource(R.drawable.sun)
                "阴" -> imageView.setImageResource(R.drawable.cloud)
                "多云" -> imageView.setImageResource(R.drawable.mcloud)
                "阵雨" -> imageView.setImageResource(R.drawable.rain)
                else -> imageView.setImageResource(R.drawable.snow)
            }

            val adapter = ArrayAdapter<Forecast>(this, android.R.layout.simple_list_item_1,weather.data.forecast)
            forcast.adapter = adapter



            Log.d("Main2","${weather.cityInfo.city} ${weather.cityInfo.parent}")
        },{
            Log.d("Main2","$it")
        })

        queue.add(stringRequest)


    }
}