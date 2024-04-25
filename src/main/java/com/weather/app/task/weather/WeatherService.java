package com.weather.app.task.weather;

import com.weather.app.task.common.DateParser;
import com.weather.app.task.infrastructure.client_api.WeatherApiFacade;

import com.weather.app.task.infrastructure.client_api.dto.WeatherDataDto;
import com.weather.app.task.weather.dto.CityResponse;
import com.weather.app.task.weather.dto.RequestDateWeather;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
class WeatherService {

    private final WeatherApiFacade weatherApiFacade;

    CityResponse getCityToSurfing(RequestDateWeather requestDateWeather) {

        List<WeatherDataDto> weatherData = weatherApiFacade.getWeatherForCity();

        LocalDateTime startDate = DateParser.parseToLocalDateTime(requestDateWeather.startDay());

        List<City> cities = weatherData.stream()
                .map(weatherDataDto -> City.getCityInRangeTime(weatherDataDto, startDate))
                .toList();

        ConditionWeather weatherSurfing = ConditionWeather.getTheBestWeatherByRangePoint(cities, new SurfingWeatherModel());

        return WeatherMapper.mapToCityResponse(weatherSurfing);
    }
}
