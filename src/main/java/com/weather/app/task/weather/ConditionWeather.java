package com.weather.app.task.weather;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Comparator;
import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
class ConditionWeather {

    private String city;
    private double averageTemperature;
    private double averageWindSpeed;
    private double pointRange;

    ConditionWeather(){}

    ConditionWeather(String city, double averageTemperature, double averageWindSpeed, double pointRange) {
        this.city = city;
        this.averageTemperature = averageTemperature;
        this.averageWindSpeed = averageWindSpeed;
        this.pointRange = pointRange;
    }

    static ConditionWeather getTheBestWeatherByRangePoint(List<City> cities, WeatherSpecification weatherSpecification) {

        return cities.stream()
                .map(city -> getWeatherInRange(city, weatherSpecification))
                .max(Comparator.comparingDouble(ConditionWeather::getPointRange))
                .orElse(null);
    }

    private static ConditionWeather createConditionWeather(double pointRange, double averageTemp, double averageWindSpeed, String city) {
        return ConditionWeather.builder()
                .pointRange(pointRange)
                .averageTemperature(averageTemp)
                .city(city)
                .averageWindSpeed(averageWindSpeed)
                .build();
    }

    private static ConditionWeather getWeatherInRange(City city, WeatherSpecification weatherSpecification) {

        final double averageTemp = WeatherCalculator.getAverageTemp(city);
        final double averageWindSpeed = WeatherCalculator.getAverageWindSpeed(city);

        if (weatherSpecification.isInRange(averageTemp, averageWindSpeed)) {

            double pointRange = weatherSpecification.calculateTheBestWeatherConditions(averageWindSpeed, averageTemp);

            return createConditionWeather(
                    pointRange,
                    averageTemp,
                    averageWindSpeed,
                    city.getName());

        }
        return ConditionWeather.builder()
                .build();
    }
}
