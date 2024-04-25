package com.weather.app.task.weather;

interface WeatherSpecification {

    boolean isInRange(double temp, double windSpeed);

    double calculateTheBestWeatherConditions(double windSpeed, double temperature);
}
