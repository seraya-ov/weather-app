package weather;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WeatherRepository extends CrudRepository<Weather, String> {
    Optional<Weather> getWeatherByCityAndTime(String city, String time);
}
