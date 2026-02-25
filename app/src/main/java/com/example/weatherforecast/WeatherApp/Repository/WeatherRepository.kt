package com.example.weatherforecast.WeatherApp.Repository

import android.util.Log
import com.example.weatherforecast.WeatherApp.data.remote.RetrofitInstance
import com.example.weatherforecast.WeatherApp.model.WeatherResponse
import retrofit2.HttpException
import java.io.IOException

//class WeatherRepository {
//
////    suspend fun getWeather(city: String): WeatherResponse {
////        return RetrofitInstance.api.getWeather(
////            city = city,
////            apiKey = "YOUR_API_KEY_HERE"
////        )
////    }
////class WeatherRepository(private val api: WeatherApi) {
//
//    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
//    suspend fun getWeather(city: String): Result<WeatherResponse> {
//        val WeatherAPiKey = "a1ee6a54cf337c5dac4ea001265afbdd"
//        return try {
//            val response = api.getWeatherByCity(
//                city = "$city,IN",
////                apiKey = GsonBuildConfig.WeatherAPiKey
//                apiKey = WeatherAPiKey
//            )
//            Result.success(response)
//        } catch (e: HttpException) {
//            Result.failure(Exception("City not found"))
//        } catch (e: IOException) {
//            Result.failure(Exception("Network error"))
//        }
//    }
//}
//}


class WeatherRepository {

    private val api = RetrofitInstance.api

    suspend fun getWeatherByCity(city: String): Result<WeatherResponse> {
//        Log.d("WEATHER_REPO", "Calling API for city = $city")
        val weatherAPiKey = "a1ee6a54cf337c5dac4ea001265afbdd"
        return try {
            val response = api.getWeatherByCity(
                city = city,
                apiKey = weatherAPiKey,
            )
            Log.d("WEATHER_REPO", "API response received")
            Result.success(response)

        } catch (e: HttpException) {
            Log.e("WEATHER_REPO", "HTTP ${e.code()}", e)
            Result.failure(Exception("City not found"))

        } catch (e: IOException) {
            Result.failure(Exception("No internet connection"))

        } catch (e: Exception) {
            Log.e("WEATHER_REPO", e.message ?: "Unknown error", e)
            Result.failure(Exception("Something went wrong"))
        }
    }
}
