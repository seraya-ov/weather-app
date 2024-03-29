package currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    private final RestTemplate restTemplate;
    private final String requestUrl;
    private final CurrencyRepository repository;
    private final CurrencyXmlDeserializer deserializer;


    public CurrencyService(CurrencyRepository repository, CurrencyXmlDeserializer deserializer, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.repository = repository;
        this.deserializer = deserializer;
        this.requestUrl = "http://www.cbr.ru/scripts/XML_daily.asp";
    }

    public List<Currency> getCurrencyHistory(int days) throws IOException {
        LocalDate today = LocalDate.now();
        ArrayList<Currency> currencyHistory = new ArrayList<>();
        for (int d = 0; d < Math.min(days, 30); ++d) {
            LocalDate from = today.minusDays(d);
            try {
                Currency currency = getCurrency(from);
                if (currency != null) {
                    currencyHistory.add(currency);
                }
            } catch (Exception e) {
                throw new IOException("Failed to parse response");
            }
        }
        return currencyHistory;
    }

    public Currency getCurrency(LocalDate from) throws IOException, SAXException {
        String date = from.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Optional<Currency> optionalCurrency = repository.findById(date);

        if (optionalCurrency.isPresent()) {
            return optionalCurrency.get();
        }

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.requestUrl).queryParam("date_req", date);
        ResponseEntity<String> response = this.restTemplate.getForEntity(builder.build().encode().toUri(), String.class);

        if (response.getBody() == null) {
            return null;
        }

        Currency currency = deserializer.deserialize(response.getBody());
        repository.save(currency);

        return currency;
    }


}
