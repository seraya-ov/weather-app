package spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import spring.entities.Weather;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final PredictService predictService;

    private static final String VIEW = "weather";
    private static final String DEFAULT_CITY = "Moscow";

    public WeatherController(WeatherService weatherService, PredictService predictService) {
        this.weatherService = weatherService;
        this.predictService = predictService;
    }

    @GetMapping("/{city}/{days}")
    public ModelAndView getWeather(@PathVariable String city, @PathVariable int days) throws IOException {
        List<Weather> weatherHistory = weatherService.getWeatherHistory(city, days);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW);
        modelAndView.addObject("weather", weatherHistory);
        modelAndView.addObject("city", city);
        modelAndView.addObject("action", "History");
        return modelAndView;
    }

    @GetMapping({"/{cityOrDays}", "/{cityOrDays}/"})
    public ModelAndView getWeather(@PathVariable String cityOrDays) throws IOException {
        try {
            int days = Integer.parseInt(cityOrDays);
            return getWeather(DEFAULT_CITY, days);
        }
        catch(NumberFormatException e) {
            return getWeather(cityOrDays, 1);
        }
    }

    @GetMapping({"", "/"})
    public ModelAndView getWeather() throws IOException {
        return getWeather(DEFAULT_CITY, 1);
    }

    @GetMapping({"/{city}/predict"})
    public ModelAndView predictWeather(@PathVariable String city) throws IOException {
        ArrayList<Weather> prediction = new ArrayList<>(Collections.singletonList(predictService.predictWeather(city)));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW);
        modelAndView.addObject("weather", prediction);
        modelAndView.addObject("city", city);
        modelAndView.addObject("action", "Forecast");
        return modelAndView;
    }

    @GetMapping({"/predict"})
    public ModelAndView predictWeather() throws IOException {
        return predictWeather(DEFAULT_CITY);
    }
}
