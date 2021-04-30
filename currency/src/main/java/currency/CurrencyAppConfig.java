package currency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.xml.parsers.ParserConfigurationException;

@Configuration
public class CurrencyAppConfig {
    @Bean
    CurrencyXmlDeserializer currencyXmlDeserializer() throws ParserConfigurationException {
        return new CurrencyXmlDeserializer();
    }

    @Bean
    RestTemplate restTemplate() { return new RestTemplate();}
}
