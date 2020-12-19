package spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import spring.deserializers.WeatherJsonDeserializer;
import spring.entities.Weather;
import spring.repositories.WeatherRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class WeatherServiceTest {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    WeatherJsonDeserializer deserializer;

    @Autowired
    WeatherRepository repository;

    @Test
    public void init() {
        WeatherService service = new WeatherService(restTemplateBuilder, repository, deserializer);
        assertNotNull(service);
    }

    @Test
    public void getWeatherHistory() {
        WeatherService service = new WeatherService(restTemplateBuilder, repository, deserializer);
        try {
            int days = Math.abs(new Random().nextInt(100)) + 1;
            List<Weather> weathers = service.getWeatherHistory("Moscow", days);
            assertNotNull(weathers);
            assertEquals(weathers.size(), Math.min(days, 7));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getWeather() {
        WeatherService service = new WeatherService(restTemplateBuilder, repository, deserializer);
        Weather weather = service.getWeather("Moscow", LocalDateTime.now());
        assertNotNull(weather);
    }
}