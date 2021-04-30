package currency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurrencyXmlDeserializerTest {
    @Test()
    public void init() {
        try {
            CurrencyXmlDeserializer deserializer = new CurrencyXmlDeserializer();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void deserialize() {
        try {
            CurrencyXmlDeserializer deserializer = new CurrencyXmlDeserializer();
            String testXml = "<?xml version=\"1.0\" encoding=\"windows-1251\"?><ValCurs Date=\"TestDate\" " +
                    "name=\"Foreign Currency Market\">" +
                    "<Valute ID=\"R01010\"><NumCode>036</NumCode><CharCode>AUD</CharCode><Nominal>1</Nominal><Name>Австралийский доллар</Name><Value>1000,12</Value></Valute>" +
                    "<Valute ID=\"R01035\"><NumCode>826</NumCode><CharCode>GBP</CharCode><Nominal>1</Nominal><Name>Фунт стерлингов Соединенного королевства</Name><Value>999,12</Value></Valute>" +
                    "<Valute ID=\"R01235\"><NumCode>840</NumCode><CharCode>USD</CharCode><Nominal>1</Nominal><Name>Доллар США</Name><Value>998.12</Value></Valute>" +
                    "<Valute ID=\"R01239\"><NumCode>978</NumCode><CharCode>EUR</CharCode><Nominal>1</Nominal><Name>Евро</Name><Value>997.12</Value></Valute>" +
                    "<Valute ID=\"R01350\"><NumCode>124</NumCode><CharCode>CAD</CharCode><Nominal>1</Nominal><Name>Канадский доллар</Name><Value>996.12</Value></Valute>" +
                    "<Valute ID=\"R01625\"><NumCode>702</NumCode><CharCode>SGD</CharCode><Nominal>1</Nominal><Name>Сингапурский доллар</Name><Value>995.12</Value></Valute></ValCurs>";
            assertEquals(new Currency("TestDate", 999.12, 997.12, 996.12, 995.12, 1000.12, 998.12), deserializer.deserialize(testXml));
        } catch (Exception e) {
            fail();
        }
    }
}