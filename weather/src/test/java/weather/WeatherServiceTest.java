package weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = {WeatherService.class, WeatherApplication.class})
public class WeatherServiceTest {
    @Autowired
    WeatherJsonDeserializer deserializer;
    @Autowired
    WeatherRepository repository;
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void init() {
        WeatherService service = new WeatherService(repository, deserializer, restTemplate);
        assertNotNull(service);
    }

    @Test
    public void getWeatherHistory() {
        WeatherService service = new WeatherService(repository, deserializer, restTemplate);
        try {
            int days = Math.abs(new Random().nextInt(100)) + 1;
            List<Weather> weathers = service.getWeatherHistory("Moscow", days);
            assertNotNull(weathers);
            assertEquals(weathers.size(), Math.min(days, 8));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getWeather() {
        WeatherService service = new WeatherService(repository, deserializer, restTemplate);
        Weather weather = service.getWeather("Moscow", LocalDateTime.now());
        assertNotNull(weather);
    }
}