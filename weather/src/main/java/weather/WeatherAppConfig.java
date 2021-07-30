package weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class WeatherAppConfig {
    @Bean
    WeatherJsonDeserializer weatherJsonDeserializer() {
        return new WeatherJsonDeserializer();
    }

    @Bean
    RestTemplate restTemplate() { return new RestTemplate();}
}
