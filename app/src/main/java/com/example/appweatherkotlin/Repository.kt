package com.example.appweatherkotlin

object Repository {
// синглтон
    var weatherList: List<Weather> = listOf()

    init {weatherList = listOf(Weather("Moscow", 15))

        Weather ("Moscow",15)
        Weather()
        Weather(temperature = 2)

    }
}