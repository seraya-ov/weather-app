package weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class WeatherAppConfig {
    @Bean
    WeatherJsonDeserializer weatherJsonDeserializer() {
        return new WeatherJsonDeserializer();
    }
}
