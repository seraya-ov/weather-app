package weather;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherJsonDeserializerTest {
    @Test
    public void deserialize() {
        try {
            WeatherJsonDeserializer deserializer = new WeatherJsonDeserializer();
            String body = "{\n" +
                    "    \"location\": {\n" +
                    "        \"name\": \"TestCity\",\n" +
                    "        \"region\": \"City of London, Greater London\",\n" +
                    "        \"country\": \"United Kingdom\",\n" +
                    "        \"lat\": 51.52,\n" +
                    "        \"lon\": -0.11,\n" +
                    "        \"tz_id\": \"Europe/London\",\n" +
                    "        \"localtime_epoch\": 1608371106,\n" +
                    "        \"localtime\": \"2020-12-19 9:45\"\n" +
                    "    },\n" +
                    "    \"forecast\": {\n" +
                    "        \"forecastday\": [\n" +
                    "            {\n" +
                    "                \"date\": \"TestDate\",\n" +
                    "                \"date_epoch\": 1608336000,\n" +
                    "                \"hour\": [\n" +
                    "                    {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}, {}," +
                    "                    {\n" +
                    "                        \"time_epoch\": 1608379200,\n" +
                    "                        \"time\": \"TestTime\",\n" +
                    "                        \"temp_c\": -1000.0,\n" +
                    "                        \"temp_f\": 53.2,\n" +
                    "                        \"is_day\": 1,\n" +
                    "                        \"condition\": {\n" +
                    "                            \"text\": \"Partly cloudy\",\n" +
                    "                            \"icon\": \"//cdn.weatherapi.com/weather/64x64/day/116.png\",\n" +
                    "                            \"code\": 1003\n" +
                    "                        },\n" +
                    "                        \"wind_mph\": 16.1,\n" +
                    "                        \"wind_kph\": -999.0,\n" +
                    "                        \"wind_degree\": 208,\n" +
                    "                        \"wind_dir\": \"TestWindDirection\",\n" +
                    "                        \"pressure_mb\": -998.0,\n" +
                    "                        \"pressure_in\": 30.2,\n" +
                    "                        \"precip_mm\": 0.0,\n" +
                    "                        \"precip_in\": 0.0,\n" +
                    "                        \"humidity\": -997,\n" +
                    "                        \"cloud\": 40,\n" +
                    "                        \"feelslike_c\": 9.2,\n" +
                    "                        \"feelslike_f\": 48.6,\n" +
                    "                        \"windchill_c\": 9.2,\n" +
                    "                        \"windchill_f\": 48.6,\n" +
                    "                        \"heatindex_c\": 11.8,\n" +
                    "                        \"heatindex_f\": 53.2,\n" +
                    "                        \"dewpoint_c\": 5.3,\n" +
                    "                        \"dewpoint_f\": 41.5,\n" +
                    "                        \"will_it_rain\": 0,\n" +
                    "                        \"chance_of_rain\": \"0\",\n" +
                    "                        \"will_it_snow\": 0,\n" +
                    "                        \"chance_of_snow\": \"0\",\n" +
                    "                        \"vis_km\": 10.0,\n" +
                    "                        \"vis_miles\": 6.0,\n" +
                    "                        \"gust_mph\": 22.1,\n" +
                    "                        \"gust_kph\": 35.6\n" +
                    "                    }" +
                    "                ]\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    }\n" +
                    "}";
            assertEquals(new Weather("TestTime", "TestCity", -1000.0, -999.0, -998.0, "TestWindDirection", -997), deserializer.deserialize(new JSONObject(body)));
        } catch (Exception e) {
            fail();
        }
    }
}