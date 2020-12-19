package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import spring.deserializers.CurrencyXmlDeserializer;
import spring.entities.Currency;
import spring.repositories.CurrencyRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyServiceTest {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    CurrencyXmlDeserializer deserializer;

    @Autowired
    CurrencyRepository repository;

    @Test
    public void init() {
        try {
            CurrencyService service = new CurrencyService(restTemplateBuilder, repository, deserializer);
            assertNotNull(service);
        }
        catch (Exception e) {
            fail();
        }

    }


    @Test
    public void getCurrencyHistory() {
        CurrencyService service = new CurrencyService(restTemplateBuilder, repository, deserializer);
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
        CurrencyService service = new CurrencyService(restTemplateBuilder, repository, deserializer);
        try {
            Currency currency = service.getCurrency(LocalDate.now());
            assertNotNull(currency);
        } catch (Exception e) {
            fail();
        }
    }
}