package predict;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {PredictApplication.class})
public class PredictServiceTest {
    @Autowired
    Environment env;
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void init() {
        PredictService service = new PredictService(env, restTemplate);
        assertNotNull(service);
    }

    @Test
    public void predictWeather() {
        PredictService service = new PredictService(env, restTemplate);
        try {
            Weather prediction = service.predictWeather("Moscow");
            assertNotNull(prediction);
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void predictCurrency() {
        PredictService service = new PredictService(env, restTemplate);
        try {
            Currency prediction = service.predictCurrency();
            assertNotNull(prediction);
        } catch (Exception e) {
            fail();
        }

    }
}