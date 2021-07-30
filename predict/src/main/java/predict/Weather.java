package predict;

import javax.persistence.*;

@Entity
public class Weather {
    @Id
    private Long id;
    private String city;
    private String time;
    private Double temp;
    private Double windKph;
    private Double pressure;
    private String windDir;
    private Integer humidity;

    private static final String DEFAULT_VALUE = "No data";

    public Weather(String time,
                   String city,
                   Double temp, Double windKph,
                   Double pressure, String windDir,
                   Integer humidity) {
        this.city = city;
        this.time = time;
        this.temp = temp;
        this.windKph = windKph;
        this.pressure = pressure;
        this.windDir = windDir;
        this.humidity = humidity;
    }

    public Weather() {
        this.time = DEFAULT_VALUE;
        this.city = DEFAULT_VALUE;
        this.temp = 0.;
        this.windKph = 0.;
        this.pressure = 0.;
        this.windDir = DEFAULT_VALUE;
        this.humidity = 0;
    }


    public String getTime() {
        return time;
    }

    public Double getTemp() {
        return temp;
    }

    public Double getWindKph() {
        return windKph;
    }

    public Double getPressure() {
        return pressure;
    }

    public String getWindDir() {
        return windDir;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public String getCity() {
        return city;
    }

    public Long getId() {
        return id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public void setWindKph(Double windKph) {
        this.windKph = windKph;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Date: " + time +
                "\n Temperature: " + temp + "C" +
                "\n Pressure " + pressure + "MB" +
                "\n Humidity: " + humidity + "%" +
                "\n Wind speed:" + windKph + "kph" +
                "\n Wind direction: " + windDir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        if (!city.equals(weather.city)) return false;
        if (!time.equals(weather.time)) return false;
        if (!temp.equals(weather.temp)) return false;
        if (!windKph.equals(weather.windKph)) return false;
        if (!pressure.equals(weather.pressure)) return false;
        if (!windDir.equals(weather.windDir)) return false;
        return humidity.equals(weather.humidity);
    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + temp.hashCode();
        result = 31 * result + windKph.hashCode();
        result = 31 * result + pressure.hashCode();
        result = 31 * result + windDir.hashCode();
        result = 31 * result + humidity.hashCode();
        return result;
    }
}