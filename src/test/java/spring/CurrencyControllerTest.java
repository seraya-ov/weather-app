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
class CurrencyControllerTest {
    @Autowired
    CurrencyService currencyService;
    @Autowired
    PredictService predictService;

    @Test
    public void init() {
        CurrencyController controller = new CurrencyController(currencyService, predictService);
        assertNotNull(controller);
    }

    @Test
    void getCurrency() {
        CurrencyController controller = new CurrencyController(currencyService, predictService);
        try {
            ModelAndView currency = controller.getCurrency( Math.abs(new Random().nextInt(100)) + 1);
            ModelAndView noDaysCurrency = controller.getCurrency();
            ModelAndView oneDayCurrency = controller.getCurrency(1);
            assertNotNull(currency);
            assertNotNull(noDaysCurrency);
            assertNotNull(oneDayCurrency);

        } catch (Exception e) {
            fail();
        }
    }


    @Test
    void predictCurrency() {
        CurrencyController controller = new CurrencyController(currencyService, predictService);
        try {
            ModelAndView prediction = controller.predictCurrency();
            assertNotNull(prediction);
        } catch (Exception e) {
            fail();
        }
    }
}