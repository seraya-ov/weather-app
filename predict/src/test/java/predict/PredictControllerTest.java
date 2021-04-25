package predict;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {PredictService.class, PredictApplication.class})
public class PredictControllerTest {
    @Autowired
    PredictService predictService;

    @Test
    public void init() {
        PredictController controller = new PredictController(predictService);
        assertNotNull(controller);
    }

    @Test
    void predictWeather() {
        PredictController controller = new PredictController(predictService);
        try {
//            ModelAndView noParamsPrediction = controller.predictWeather();
//            ModelAndView prediction = controller.predictWeather("London");
            String noParamsPrediction = controller.predictWeather();
            String prediction = controller.predictWeather("London");
            assertNotNull(noParamsPrediction);
            assertNotNull(prediction);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void predictCurrency() {
        PredictController controller = new PredictController(predictService);
        try {
//            ModelAndView prediction = controller.predictCurrency();
            String prediction = controller.predictCurrency();
            assertNotNull(prediction);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}