package pl.nullpointerexception.weather.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.nullpointerexception.weather.model.WeatherDto;
import pl.nullpointerexception.weather.webclient.weather.WeatherClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherDto getWeather() {
        return weatherClient.getWeatherForCity("warszawa");
    }


}
