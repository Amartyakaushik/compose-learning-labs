package com.example.weatherforecast.WeatherApp.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.WeatherApp.Repository.WeatherRepository
import com.example.weatherforecast.WeatherApp.model.WeatherResponse
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val repository = WeatherRepository()
    private val _weather = mutableStateOf<WeatherResponse?>(null)
    val weather: State<WeatherResponse?> = _weather

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    fun fetchWeather(city: String) {
//        viewModelScope.launch {
//            try {
//                _weather.value = repository.getWeather(city)
//                _error.value = null
//            } catch (e: Exception) {
//                _error.value = "City not found or network error"
//            }
//        }

        viewModelScope.launch {
            val result = repository.getWeatherByCity(city)

            result
                .onSuccess { response ->
//                    Log.d("WEATHER_VM", "Fetching weather for $city")
                    _weather.value = response
                    _error.value = null

//                    Log.d("WEATHER_VM", "Weather updated in state")
                }
                .onFailure { exception ->
                    _weather.value = null

//                    Log.e("WEATHER_VM", "Error", exception)
                    _error.value = exception.message ?: "City not found or network error"
                }
        }

    }


}