package predict;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {PredictApplication.class})
public class PredictServiceTest {

    @Test
    public void init() {
        PredictService service = new PredictService();
        assertNotNull(service);
    }

    @Test
    public void predictWeather() {
        PredictService service = new PredictService();
        try {
            Weather prediction = service.predictWeather("Moscow");
            assertNotNull(prediction);
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void predictCurrency() {
        PredictService service = new PredictService();
        try {
            Currency prediction = service.predictCurrency();
            assertNotNull(prediction);
        } catch (Exception e) {
            fail();
        }

    }
}