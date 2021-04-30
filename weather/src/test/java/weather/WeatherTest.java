package weather;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {
    private final String testTime = "12-12-2020";
    private final String testCity = "TestCity";
    private final double testTemp = 1.0;
    private final double testWindKph = 2.0;
    private final double testPressure = 3.0;
    private final String testWindDirection = "TestWindDirection";
    private final int testHumidity = 4;
    private final Weather testWeather = new Weather(testTime, testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);

    @Test
    void getTime() {
        assertEquals(testWeather.getTime(), testTime);
    }

    @Test
    void getTemp() {
        assertEquals(testWeather.getTemp(), testTemp);
    }

    @Test
    void getWindKph() {
        assertEquals(testWeather.getWindKph(), testWindKph);
    }

    @Test
    void getPressure() {
        assertEquals(testWeather.getPressure(), testPressure);
    }

    @Test
    void getWindDir() {
        assertEquals(testWeather.getWindDir(), testWindDirection);
    }

    @Test
    void getHumidity() {
        assertEquals(testWeather.getHumidity(), testHumidity);
    }

    @Test
    void getCity() {
        assertEquals(testWeather.getCity(), testCity);
    }

    @Test
    void setTime() {
        Weather weather = new Weather(testTime, testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);
        weather.setTime("OtherTestTime");
        assertEquals(weather.getTime(), "OtherTestTime");
    }

    @Test
    void setTemp() {
        Weather weather = new Weather(testTime, testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);
        weather.setTemp(-1.0);
        assertEquals(weather.getTemp(), -1.0);
    }

    @Test
    void setWindKph() {
        Weather weather = new Weather(testTime, testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);
        weather.setWindKph(-1.0);
        assertEquals(weather.getWindKph(), -1.0);
    }

    @Test
    void setPressure() {
        Weather weather = new Weather(testTime, testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);
        weather.setPressure(-1.0);
        assertEquals(weather.getPressure(), -1.0);
    }

    @Test
    void setWindDir() {
        Weather weather = new Weather(testTime, testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);
        weather.setWindDir("OtherWindDir");
        assertEquals(weather.getWindDir(), "OtherWindDir");
    }
    ///src/main/resources/META-INF/resources/WEB-INF/

    @Test
    void setHumidity() {
        Weather weather = new Weather(testTime, testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);
        weather.setHumidity(-1);
        assertEquals(weather.getHumidity(), -1);
    }

    @Test
    void setCity() {
        Weather weather = new Weather(testTime, testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);
        weather.setCity("OtherCity");
        assertEquals(weather.getCity(), "OtherCity");
    }

    @Test
    public void equalsTest() {
        Weather weather = new Weather(testTime, testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);
        Weather other = new Weather("OtherTime", testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);
        assertNotEquals(weather, other);
        assertEquals(weather, weather);

        other.setTime(testTime);
        other.setTemp(-1000.0);
        assertNotEquals(weather, other);
    }

    @Test
    public void hashTest() {
        Weather weather = new Weather(testTime, testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);
        Weather other = new Weather(testTime, testCity, testTemp, testWindKph, testPressure, testWindDirection, testHumidity);

        assertEquals(weather.hashCode(), other.hashCode());
    }
}