package currency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.parsers.ParserConfigurationException;

@Configuration
public class CurrencyAppConfig {
    @Bean
    CurrencyXmlDeserializer currencyXmlDeserializer() throws ParserConfigurationException {
        return new CurrencyXmlDeserializer();
    }
}
