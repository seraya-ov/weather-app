package predict;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
public class PredictService {

    private final Environment env;
    private final RestTemplate restTemplate;

    @Autowired
    public PredictService(Environment env, RestTemplate restTemplate) {
        this.env = env;
        this.restTemplate = restTemplate;
    }

    public Weather predictWeather(String city) {
        String weatherUrl = this.env.getProperty("predict.weatherUrl"); //"http://weather:9002/weather_xml";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(weatherUrl).queryParam("city", city).queryParam("days", 8);
        ResponseEntity<Weather[]> response = this.restTemplate.getForEntity(builder.build().encode().toUri(), Weather[].class);

        if (response.getBody() == null) {
            return null;
        }

        Weather[] weathers = response.getBody();

        SimpleRegression tempRegression = new SimpleRegression(true);
        SimpleRegression windKphRegression = new SimpleRegression(true);
        SimpleRegression pressureRegression = new SimpleRegression(true);
        SimpleRegression humidityRegression = new SimpleRegression(true);

        int maxIndex = weathers.length - 1;

        for (int i = maxIndex; i > 0; --i) {
            tempRegression.addData(weathers[i].getTemp(), weathers[i - 1].getTemp());
            windKphRegression.addData(weathers[i].getWindKph(), weathers[i - 1].getWindKph());
            pressureRegression.addData(weathers[i].getPressure(), weathers[i - 1].getPressure());
            humidityRegression.addData(weathers[i].getHumidity(), weathers[i - 1].getHumidity());
        }

        double temp = Precision.round(tempRegression.predict(weathers[0].getTemp()), 1);
        double windKph = Precision.round(windKphRegression.predict(weathers[0].getWindKph()), 1);
        double pressure = Precision.round(pressureRegression.predict(weathers[0].getPressure()), 0);
        double humidity = Precision.round(humidityRegression.predict(weathers[0].getHumidity()), 0);

        return new Weather(LocalDate.now().plusDays(1).toString(), city, temp, windKph, pressure, weathers[0].getWindDir(), Math.min((int) humidity, 100));
    }

    public Currency predictCurrency() {
        String currencyUrl = this.env.getProperty("predict.currencyUrl"); //"http://currency:9001/currency_xml";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(currencyUrl).queryParam("days", 8);
        ResponseEntity<Currency[]> response = this.restTemplate.getForEntity(builder.build().encode().toUri(), Currency[].class);

        if (response.getBody() == null) {
            return null;
        }

        Currency [] currencies = response.getBody();

        SimpleRegression gbrRegression = new SimpleRegression(true);
        SimpleRegression eurRegression = new SimpleRegression(true);
        SimpleRegression cadRegression = new SimpleRegression(true);
        SimpleRegression sgdRegression = new SimpleRegression(true);
        SimpleRegression audRegression = new SimpleRegression(true);
        SimpleRegression usdRegression = new SimpleRegression(true);

        int maxIndex = currencies.length - 1;

        for (int i = maxIndex; i > 0; --i) {
            gbrRegression.addData(currencies[i].getGbr(), currencies[i - 1].getGbr());
            eurRegression.addData(currencies[i].getEur(), currencies[i - 1].getEur());
            cadRegression.addData(currencies[i].getCad(), currencies[i - 1].getCad());
            sgdRegression.addData(currencies[i].getSgd(), currencies[i - 1].getSgd());
            audRegression.addData(currencies[i].getAud(), currencies[i - 1].getAud());
            usdRegression.addData(currencies[i].getUsd(), currencies[i - 1].getUsd());
        }

        double gbr = Precision.round(gbrRegression.predict(currencies[0].getGbr()), 4);
        double eur = Precision.round(gbrRegression.predict(currencies[0].getEur()), 4);
        double cad = Precision.round(gbrRegression.predict(currencies[0].getCad()), 4);
        double sgd = Precision.round(gbrRegression.predict(currencies[0].getSgd()), 4);
        double aud = Precision.round(gbrRegression.predict(currencies[0].getAud()), 4);
        double usd = Precision.round(gbrRegression.predict(currencies[0].getUsd()), 4);

        return new Currency(LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), gbr, eur, cad, sgd, aud, usd);
    }


}
