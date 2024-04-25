package com.weather.app.task.infrastructure.client_api;

import com.weather.app.task.dictionary.CityDictionary;
import com.weather.app.task.infrastructure.client_api.dto.WeatherDataDto;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
@Component
@EqualsAndHashCode
class WeatherClient {

    private final WebClient webClient;

    private static final String WEATHER_URL = "https://api.weatherbit.io/v2.0/forecast/daily?";
    private static final String API_KEY = "287a3743c7524306bba4b860a8152573";
    private static final Integer DAYS = 16;

    @Autowired
    private WeatherClient(WebClient webClient) {
        this.webClient = webClient;
    }

    List<WeatherDataDto> getWeatherForCity() {

        return Flux.fromArray(CityDictionary.values())
                .flatMap(cityDictionary -> callWebClientGetMethod("city={city}&days{days}&key={apiKey}",
                        WeatherDataDto.class,
                        cityDictionary.getCity(), DAYS, API_KEY))
                .collectList()
                .block();

    }

    private Mono<WeatherDataDto> callWebClientGetMethod(String url, Class<WeatherDataDto> responseType, Object... objects) {
        return webClient
                .get()
                .uri(WEATHER_URL + url, objects)
                .retrieve()
                .bodyToMono(responseType);
    }
}
