package weather;

import org.json.JSONObject;

public class WeatherJsonDeserializer {
    public Weather deserialize(JSONObject json) {
        JSONObject dayWeatherJson = (JSONObject) ((JSONObject) (json
                .getJSONObject("forecast")
                .getJSONArray("forecastday")
                .get(0))).getJSONArray("hour").get(12);
        String city = json.getJSONObject("location").getString("name");
        String time = dayWeatherJson.getString("time");
        Double temp = dayWeatherJson.getDouble("temp_c");
        Double windKph = dayWeatherJson.getDouble("wind_kph");
        Double pressure = dayWeatherJson.getDouble("pressure_mb");
        String windDir = dayWeatherJson.getString("wind_dir");
        Integer humidity = dayWeatherJson.getInt("humidity");
        return new Weather(time, city, temp, windKph, pressure, windDir, humidity);
    }
}
