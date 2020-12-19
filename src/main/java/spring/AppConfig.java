package spring;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.deserializers.CurrencyXmlDeserializer;
import spring.deserializers.WeatherJsonDeserializer;

import javax.xml.parsers.ParserConfigurationException;

@Configuration
public class AppConfig {
    @Bean
    RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }

    @Bean
    CurrencyXmlDeserializer currencyXmlDeserializer() throws ParserConfigurationException {
        return new CurrencyXmlDeserializer();
    }

    @Bean
    WeatherJsonDeserializer weatherJsonDeserializer() {
        return new WeatherJsonDeserializer();
    }
}
