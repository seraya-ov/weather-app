package spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class WeatherControllerTest {
    @Autowired
    WeatherService weatherService;
    @Autowired
    PredictService predictService;

    @Test
    public void init() {
        WeatherController controller = new WeatherController(weatherService, predictService);
        assertNotNull(controller);
    }

    @Test
    void getWeather() {
        WeatherController controller = new WeatherController(weatherService, predictService);
        try {
            ModelAndView daysWeather = controller.getWeather(Integer.toString(Math.abs(new Random().nextInt(100)) + 1));
            ModelAndView cityWeather = controller.getWeather("London");
            ModelAndView noParamsWeather = controller.getWeather();
            ModelAndView oneDayWeather = controller.getWeather(Integer.toString(1));
            assertNotNull(daysWeather);
            assertNotNull(noParamsWeather);
            assertNotNull(oneDayWeather);
            assertNotNull(cityWeather);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    void predictWeather() {
        WeatherController controller = new WeatherController(weatherService, predictService);
        try {
            ModelAndView noParamsPrediction = controller.predictWeather();
            ModelAndView prediction = controller.predictWeather("London");
            assertNotNull(noParamsPrediction);
            assertNotNull(prediction);
        } catch (Exception e) {
            fail();
        }
    }
}