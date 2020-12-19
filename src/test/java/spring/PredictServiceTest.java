package spring;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import spring.entities.Currency;
import spring.entities.Weather;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PredictServiceTest {
    @Autowired
    CurrencyService currencyService;
    @Autowired
    WeatherService weatherService;

    @Test
    public void init() {
        PredictService service = new PredictService(currencyService, weatherService);
        assertNotNull(service);
    }

    @Test
    public void predictWeather() {
        PredictService service = new PredictService(currencyService, weatherService);
        try {
            Weather prediction = service.predictWeather("Moscow");
            assertNotNull(prediction);
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void predictCurrency() {
        PredictService service = new PredictService(currencyService, weatherService);
        try {
            Currency prediction = service.predictCurrency();
            assertNotNull(prediction);
        } catch (Exception e) {
            fail();
        }

    }
}