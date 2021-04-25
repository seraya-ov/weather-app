package predict;

import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


@RestController
public class PredictController {
//    private static final String WEATHER_VIEW = "weather";
//    private static final String CURRENCY_VIEW = "currency";
    private static final String DEFAULT_CITY = "Moscow";
    
    private final PredictService predictService;

    public PredictController(PredictService predictService) {
        this.predictService = predictService;
    }


    @GetMapping({"/weather/{city}"})
    public String predictWeather(@PathVariable String city) throws IOException, ParserConfigurationException, SAXException {
//        ArrayList<Weather> prediction = new ArrayList<>(Collections.singletonList(predictService.predictWeather(city)));
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName(WEATHER_VIEW);
//        modelAndView.addObject("prediction", prediction);
//        modelAndView.addObject("city", city);
//        modelAndView.addObject("action", "Forecast");
        return predictService.predictWeather(city).toString();
    }

    @GetMapping({"/weather"})
    public String predictWeather() throws IOException, ParserConfigurationException, SAXException {
        return predictWeather(DEFAULT_CITY);
    }

    @GetMapping({"/currency"})
    public String predictCurrency() throws IOException, ParserConfigurationException, SAXException {
//        ArrayList<Currency> prediction = new ArrayList<>(Collections.singletonList(predictService.predictCurrency()));
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName(CURRENCY_VIEW);
//        modelAndView.addObject(CURRENCY_VIEW, prediction);
        return predictService.predictCurrency().toString();
    }
}
