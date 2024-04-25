package com.weather.app.task.infrastructure.client_api;

import com.weather.app.task.infrastructure.client_api.dto.WeatherDataDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class WeatherApiFacade {

    private final WeatherClient weatherClient;

    public List<WeatherDataDto> getWeatherForCity(){
        return weatherClient.getWeatherForCity();
    }
}
