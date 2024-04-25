package com.weather.app.task.weather;

import com.weather.app.task.common.DateParser;
import com.weather.app.task.infrastructure.client_api.dto.WeatherDataDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
class City {
    private final String name;
    private final List<CityWeather> cityWeathers;

    City(String name, List<CityWeather> cityWeathers) {
        this.name = name;
        this.cityWeathers = cityWeathers;
    }

    static City getCityInRangeTime(final WeatherDataDto weatherDataDto, final LocalDateTime selectedDay) {

        WeatherDate weatherDate = WeatherDate.create(selectedDay);

        List<CityWeather> cityWeathers = weatherDataDto.data().stream()
                .filter(weatherDto -> weatherDate.isDateInRange(DateParser.parseToLocalDate(weatherDto.datetime())))
                .map(weatherDto -> CityWeather.createCityWeather(
                        weatherDataDto.city_name(),
                        DateParser.parseToLocalDateTime(weatherDto.datetime()),
                        weatherDto.temp(),
                        weatherDto.wind_spd()))
                .toList();

        return new City(weatherDataDto.city_name(), cityWeathers);
    }
}
