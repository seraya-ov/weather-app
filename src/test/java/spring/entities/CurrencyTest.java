package spring.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurrencyTest {
    private final Currency testCurrency = new Currency("TestDate",
            1.0, 2.0, 3.0, 4.0, 5.0, 6.0);

    @Test
    public void getDate() {
        assertEquals(testCurrency.getDate(), "TestDate");
    }

    @Test
    public void getGbr() {
        assertEquals(testCurrency.getGbr(), 1.0);
    }

    @Test
    public void getEur() {
        assertEquals(testCurrency.getEur(), 2.0);
    }

    @Test
    public void getCad() {
        assertEquals(testCurrency.getCad(), 3.0);
    }

    @Test
    public void getSgd() {
        assertEquals(testCurrency.getSgd(), 4.0);
    }

    @Test
    public void getAud() {
        assertEquals(testCurrency.getAud(), 5.0);
    }

    @Test
    public void getUsd() {
        assertEquals(testCurrency.getUsd(), 6.0);
    }

    @Test
    public void setGbr() {
        Currency currency = new Currency("TestDate",
                100.0, 100.0, 100.0, 100.0, 100.0, 100.0);
        currency.setGbr(1000.0);
        assertEquals(currency.getGbr(), 1000.0);
    }

    @Test
    public void setEur() {
        Currency currency = new Currency("TestDate",
                100.0, 100.0, 100.0, 100.0, 100.0, 100.0);
        currency.setEur(1000.0);
        assertEquals(currency.getEur(), 1000.0);
    }

    @Test
    public void setCad() {
        Currency currency = new Currency("TestDate",
                100.0, 100.0, 100.0, 100.0, 100.0, 100.0);
        currency.setCad(1000.0);
        assertEquals(currency.getCad(), 1000.0);
    }

    @Test
    public void setSgd() {
        Currency currency = new Currency("TestDate",
                100.0, 100.0, 100.0, 100.0, 100.0, 100.0);
        currency.setSgd(1000.0);
        assertEquals(currency.getSgd(), 1000.0);
    }

    @Test
    public void setAud() {
        Currency currency = new Currency("TestDate",
                100.0, 100.0, 100.0, 100.0, 100.0, 100.0);
        currency.setAud(1000.0);
        assertEquals(currency.getAud(), 1000.0);
    }

    @Test
    public void setUsd() {
        Currency currency = new Currency("TestDate",
                100.0, 100.0, 100.0, 100.0, 100.0, 100.0);
        currency.setUsd(1000.0);
        assertEquals(currency.getUsd(), 1000.0);
    }

    @Test
    public void setDate() {
        Currency currency = new Currency("TestDate",
                100.0, 100.0, 100.0, 100.0, 100.0, 100.0);
        currency.setDate("OtherTestDate");
        assertEquals(currency.getDate(), "OtherTestDate");
    }
}