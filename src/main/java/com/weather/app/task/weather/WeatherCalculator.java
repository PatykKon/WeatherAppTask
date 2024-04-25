package com.weather.app.task.weather;

import java.util.List;
class WeatherCalculator {

    static double getAverageTemp(City city){
        final List<Double> temps = city.getCityWeathers().stream().map(CityWeather::getTemp).toList();
        return temps.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    static double getAverageWindSpeed(City city){
        final List<Double> windSpeeds = city.getCityWeathers().stream().map(CityWeather::getWind).toList();
        return windSpeeds.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}
