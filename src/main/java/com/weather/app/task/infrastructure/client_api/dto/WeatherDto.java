package com.weather.app.task.infrastructure.client_api.dto;

import lombok.Builder;

@Builder
public record WeatherDto(
        String city,
        Double temp,
        Double wind_spd,
        String datetime) {
}
