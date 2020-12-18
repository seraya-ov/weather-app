package spring;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import spring.deserializers.WeatherJsonDeserializer;
import spring.entities.Weather;
import spring.repositories.WeatherRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WeatherService {
    private final String key;
    private final String requestUrl;
    private final RestTemplate restTemplate;
    private final WeatherRepository repository;
    private final WeatherJsonDeserializer deserializer;

    @Autowired
    public WeatherService(@Qualifier("restTemplateBuilder") RestTemplateBuilder restTemplateBuilder, WeatherRepository repository, WeatherJsonDeserializer deserializer) {
        this.restTemplate = restTemplateBuilder.build();
        this.repository = repository;
        this.deserializer = deserializer;
        this.key = "44d5ab0f808549ec95294630200612";
        this.requestUrl = "http://api.weatherapi.com/v1/history.json";
    }


    public List<Weather> getWeatherHistory(String city, int days) throws IOException {
        LocalDateTime today = LocalDateTime.now().minusDays(1);

        List<Weather> weatherHistory = new ArrayList<>();
        for (int d = 0; d < Math.min(days, 8); ++d) {
            LocalDateTime from = today.minusDays(d);
            try {
                Weather weather = getWeather(city, from);
                if (weather != null) {
                    weatherHistory.add(weather);
                }
            } catch (JSONException e) {
                throw new IOException("Failed to parse response");
            }
        }
        return weatherHistory;
    }

    public Weather getWeather(String city, LocalDateTime from) {
        String date = from.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Optional<Weather> optionalWeather = repository.getWeatherByCityAndTime(city, date);

        if (optionalWeather.isPresent()) {
            return optionalWeather.get();
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.requestUrl)
                .queryParam("key", this.key)
                .queryParam("q", city)
                .queryParam("dt", date);
        try {
            ResponseEntity<String> response = this.restTemplate.getForEntity(builder.build().encode().toUri(), String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                String body = response.getBody();
                if (body == null) {
                    return null;
                }
                Weather weather = deserializer.deserialize(new JSONObject(body), city);
                repository.save(weather);
                return weather;
            }
        } catch (HttpClientErrorException e) {
            return null;
        }
        return null;
    }


}
