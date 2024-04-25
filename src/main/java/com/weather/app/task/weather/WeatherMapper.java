package com.weather.app.task.weather;

import com.weather.app.task.weather.dto.CityResponse;

class WeatherMapper {

    static CityResponse mapToCityResponse(ConditionWeather conditionWeather) {
        return CityResponse.builder()
                .city(conditionWeather.getCity())
                .temp(conditionWeather.getAverageTemperature())
                .windSpeed(conditionWeather.getAverageWindSpeed())
                .build();
    }
}


