package pl.nullpointerexception.weather.webclient.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.nullpointerexception.weather.model.WeatherDto;
import pl.nullpointerexception.weather.webclient.weather.dto.OpenWeatherWeatherDto;

@Component
public class WeatherClient {

    private static final String WEATER_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "--- put api key here ---";
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeatherForCity(String city) {
        OpenWeatherWeatherDto openWeatherWeatherDto = callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherWeatherDto.class,
                city, API_KEY);
        return WeatherDto.builder()
                .temperature(openWeatherWeatherDto.getMain().getTemp())
                .pressure(openWeatherWeatherDto.getMain().getPressure())
                .humidity(openWeatherWeatherDto.getMain().getHumidity())
                .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                .build();
    }

    public String getForecast(double lat, double lon) {
        return callGetMethod("onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}&units=metric&lang=pl",
                String.class,
                lat, lon, API_KEY);
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATER_URL + url,
                responseType, objects);
    }

}
