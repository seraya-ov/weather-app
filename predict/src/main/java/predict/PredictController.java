package predict;

import org.springframework.web.bind.annotation.*;


@RestController
public class PredictController {
    private static final String DEFAULT_CITY = "Moscow";
    
    private final PredictService predictService;

    public PredictController(PredictService predictService) {
        this.predictService = predictService;
    }


    @GetMapping({"/weather/{city}"})
    public String predictWeather(@PathVariable String city) {
        return predictService.predictWeather(city).toString();
    }

    @GetMapping({"/weather"})
    public String predictWeather() {
        return predictWeather(DEFAULT_CITY);
    }

    @GetMapping({"/currency"})
    public String predictCurrency() {
        return predictService.predictCurrency().toString();
    }
}
