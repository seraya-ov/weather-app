package spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import spring.entities.Currency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService currencyService;
    private final PredictService predictService;
    private static final String VIEW = "currency";

    public CurrencyController(CurrencyService currencyService, PredictService predictService) {
        this.currencyService = currencyService;
        this.predictService = predictService;
    }

    @GetMapping("/{days}")
    public ModelAndView getCurrency(@PathVariable int days) throws IOException {
        List<Currency> currencyHistory = currencyService.getCurrencyHistory(days);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW);
        modelAndView.addObject(VIEW, currencyHistory);
        return modelAndView;
    }

    @GetMapping({"", "/"})
    public ModelAndView getCurrency() throws IOException {
        return getCurrency(1);
    }

    @GetMapping({"/predict"})
    public ModelAndView predictCurrency() throws IOException {
        ArrayList<Currency> prediction = new ArrayList<>(Collections.singletonList(predictService.predictCurrency()));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(VIEW);
        modelAndView.addObject(VIEW, prediction);
        return modelAndView;
    }

}
