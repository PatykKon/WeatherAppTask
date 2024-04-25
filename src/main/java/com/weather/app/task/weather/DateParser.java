package com.weather.app.task.weather;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateParser {

    public static LocalDate parseToLocalDate(String dateString) {

        try {
            return LocalDate.parse(dateString);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Something went wrong: " + e.getMessage(), dateString, e.getErrorIndex());

        }
    }

    public static LocalDateTime parseToLocalDateTime(String dateString) {

        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateString,dateFormatter);
            LocalTime time = LocalTime.of(0,0);

            return LocalDateTime.of(date,time);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Something went wrong: " + e.getMessage(), dateString, e.getErrorIndex());

        }
    }
}
