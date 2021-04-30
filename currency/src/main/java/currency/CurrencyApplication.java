package currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CurrencyApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(currency.CurrencyApplication.class, args);
    }
}

