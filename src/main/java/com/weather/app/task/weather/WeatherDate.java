package com.weather.app.task.weather;

import java.time.LocalDate;
import java.time.LocalDateTime;

class WeatherDate {

    private final LocalDateTime selectedDate;

    private WeatherDate(LocalDateTime selectedDate) {
        this.selectedDate = checkSelectedDate(selectedDate);
    }

    static WeatherDate create(LocalDateTime selectedDate) {
        return new WeatherDate(selectedDate);
    }

    private LocalDateTime checkSelectedDate(LocalDateTime selectedDate) {
        if (selectedDate == null) {
            throw new RuntimeException("Date can not be null!");
        }
        if (selectedDate.isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Date can not be past!");
        }
        return selectedDate;
    }

    public boolean isDateInRange(LocalDate givenDate) {

        LocalDate selectDate = selectedDate.toLocalDate();

        return selectDate.isBefore(givenDate) || selectDate.isEqual(givenDate);
    }
}
