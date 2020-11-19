package pl.nullpointerexception.weather.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDto {
    private float temperature;
    private int pressure;
    private int humidity;
    private float windSpeed;
}
