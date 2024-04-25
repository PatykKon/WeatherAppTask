package com.weather.app.task.weather.dto;

import lombok.Builder;

@Builder
public record CityResponse(
        String city,
        double temp,
        double windSpeed
) {
}
