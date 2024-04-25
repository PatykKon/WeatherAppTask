package com.weather.app.task.weather.dto;

import lombok.Builder;

@Builder
public record RequestDateWeather(
        String startDay
) {
}
