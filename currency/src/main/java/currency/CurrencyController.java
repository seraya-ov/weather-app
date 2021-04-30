package currency;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.List;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/{days}")
    public List<Currency> getCurrency(@PathVariable int days) throws IOException {
        return currencyService.getCurrencyHistory(days);
    }

    @GetMapping({"", "/"})
    public List<Currency> getCurrency() throws IOException {
        return getCurrency(1);
    }

    @GetMapping("/currency_xml")
    public List<Currency> currency(@RequestParam @Min(1) int days) throws IOException {
        return currencyService.getCurrencyHistory(days);
    }

}
