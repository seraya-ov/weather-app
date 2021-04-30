package currency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CurrencyApplication.class, CurrencyService.class})
public class CurrencyServiceTest {
    @Autowired
    CurrencyXmlDeserializer deserializer;
    @Autowired
    CurrencyRepository repository;
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void init() {
        try {
            CurrencyService service = new CurrencyService(repository, deserializer, restTemplate);
            assertNotNull(service);
        }
        catch (Exception e) {
            fail();
        }

    }


    @Test
    public void getCurrencyHistory() {
        CurrencyService service = new CurrencyService(repository, deserializer, restTemplate);
        try {
            int days = Math.abs(new Random().nextInt(100)) + 1;
            List<Currency> currencies = service.getCurrencyHistory(days);
            assertNotNull(currencies);
            assertEquals(currencies.size(), Math.min(days, 30));
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void getCurrency() {
        CurrencyService service = new CurrencyService(repository, deserializer, restTemplate);
        try {
            Currency currency = service.getCurrency(LocalDate.now());
            assertNotNull(currency);
        } catch (Exception e) {
            fail();
        }
    }
}