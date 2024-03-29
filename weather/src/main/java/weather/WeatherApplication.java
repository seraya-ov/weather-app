package weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WeatherApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(weather.WeatherApplication.class, args);
    }
}

