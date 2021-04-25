package weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {WeatherService.class, WeatherApplication.class})
public class WeatherControllerTest {
    @Autowired
    WeatherService weatherService;

    @Test
    public void init() {
        WeatherController controller = new WeatherController(weatherService);
        assertNotNull(controller);
    }

    @Test
    void getWeather() {
        WeatherController controller = new WeatherController(weatherService);
        try {
//            ModelAndView daysWeather = controller.getWeather(Integer.toString(Math.abs(new Random().nextInt(100)) + 1));
//            ModelAndView cityWeather = controller.getWeather("London");
//            ModelAndView noParamsWeather = controller.getWeather();
//            ModelAndView oneDayWeather = controller.getWeather(Integer.toString(1));

            List<Weather> daysWeather = controller.getWeather(Integer.toString(Math.abs(new Random().nextInt(100)) + 1));
            List<Weather> cityWeather = controller.getWeather("London");
            List<Weather> noParamsWeather = controller.getWeather();
            List<Weather> oneDayWeather = controller.getWeather(Integer.toString(1));

            assertNotNull(daysWeather);
            assertNotNull(noParamsWeather);
            assertNotNull(oneDayWeather);
            assertNotNull(cityWeather);
        } catch (Exception e) {
            fail();
        }
    }
}