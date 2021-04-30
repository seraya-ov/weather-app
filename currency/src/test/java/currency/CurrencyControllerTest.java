package currency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {CurrencyApplication.class, CurrencyService.class})
public class CurrencyControllerTest {
    @Autowired
    CurrencyService currencyService;

    @Test
    public void init() {
        CurrencyController controller = new CurrencyController(currencyService);
        assertNotNull(controller);
    }

    @Test
    void getCurrency() {
        CurrencyController controller = new CurrencyController(currencyService);
        try {
            List<Currency> currency = controller.getCurrency( Math.abs(new Random().nextInt(100)) + 1);
            List<Currency> noDaysCurrency = controller.getCurrency();
            List<Currency> oneDayCurrency = controller.getCurrency(1);

            assertNotNull(currency);
            assertNotNull(noDaysCurrency);
            assertNotNull(oneDayCurrency);

        } catch (Exception e) {
            fail();
        }
    }
}