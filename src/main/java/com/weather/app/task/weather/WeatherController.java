package com.weather.app.task.weather;

import com.weather.app.task.weather.dto.CityResponse;
import com.weather.app.task.weather.dto.RequestDateWeather;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
class WeatherController {

    private final WeatherService weatherService;

    @PostMapping("/get-city")
    CityResponse getCity(@RequestBody RequestDateWeather requestDateWeather) {
        return weatherService.getCityToSurfing(requestDateWeather);
    }
}
