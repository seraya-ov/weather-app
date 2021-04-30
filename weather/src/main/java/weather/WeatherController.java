package weather;

import com.sun.istack.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.List;

@RestController
public class WeatherController {

    private final WeatherService weatherService;
    private static final String DEFAULT_CITY = "Moscow";

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}/{days}")
    public List<Weather> getWeather(@PathVariable String city, @PathVariable int days) throws IOException {
        return weatherService.getWeatherHistory(city, days);
    }

    @GetMapping({"/{cityOrDays}", "/{cityOrDays}/"})
    public List<Weather> getWeather(@PathVariable String cityOrDays) throws IOException {
        try {
            int days = Integer.parseInt(cityOrDays);
            return getWeather(DEFAULT_CITY, days);
        }
        catch(NumberFormatException e) {
            return getWeather(cityOrDays, 1);
        }
    }

    @GetMapping({"", "/"})
    public List<Weather> getWeather() throws IOException {
        return getWeather(DEFAULT_CITY, 1);
    }

    @GetMapping("/weather_xml")
    public List<Weather> weather(@RequestParam @Min(1) int days, @RequestParam @Nullable String city) throws IOException {
        System.out.println("get");
        System.out.println(weatherService.getWeatherHistory(city, days).toString());
        return weatherService.getWeatherHistory(city, days);
    }
}
