package com.weather.app.task.weather;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
class CityWeather {

    private final String city;
    private final LocalDateTime dataTime;
    private final Double temp;
    private final Double wind;

    CityWeather(String city, LocalDateTime dataTime, Double temp, Double wind) {
        this.city = city;
        this.dataTime = dataTime;
        this.temp = temp;
        this.wind = wind;
    }

    static CityWeather createCityWeather(String city, LocalDateTime startTime, double temp, double wind) {

        return new CityWeather(city, startTime, temp, wind);
    }
}
