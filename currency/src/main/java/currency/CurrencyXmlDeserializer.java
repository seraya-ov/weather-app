package currency;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;


public class CurrencyXmlDeserializer {
    private static final String CURRENCY_TAG_NAME = "Value";
    private final DocumentBuilder documentBuilder;

    public CurrencyXmlDeserializer() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        documentBuilder = factory.newDocumentBuilder();
    }

    public Currency deserialize(String xml) throws IOException, SAXException {
        Document doc = documentBuilder.parse(new InputSource(new StringReader(xml)));

        Currency currency = new Currency();

        NodeList currencies = ((Element) doc.getElementsByTagName("ValCurs").item(0)).getElementsByTagName("Valute");
        currency.setDate(((Element) doc.getElementsByTagName("ValCurs").item(0)).getAttribute("Date"));

        for (int i = 0; i < currencies.getLength(); ++i) {
            Element element = (Element) currencies.item(i);
            switch (element.getAttribute("ID")) {
                case "R01010":
                    currency.setAud(Double.parseDouble((element.getElementsByTagName(CURRENCY_TAG_NAME).item(0)).getTextContent().replace(",", ".")));
                    break;
                case "R01035":
                    currency.setGbr(Double.parseDouble((element.getElementsByTagName(CURRENCY_TAG_NAME).item(0)).getTextContent().replace(",", ".")));
                    break;
                case "R01235":
                    currency.setUsd(Double.parseDouble((element.getElementsByTagName(CURRENCY_TAG_NAME).item(0)).getTextContent().replace(",", ".")));
                    break;
                case "R01239":
                    currency.setEur(Double.parseDouble((element.getElementsByTagName(CURRENCY_TAG_NAME).item(0)).getTextContent().replace(",", ".")));
                    break;
                case "R01350":
                    currency.setCad(Double.parseDouble((element.getElementsByTagName(CURRENCY_TAG_NAME).item(0)).getTextContent().replace(",", ".")));
                    break;
                case "R01625":
                    currency.setSgd(Double.parseDouble((element.getElementsByTagName(CURRENCY_TAG_NAME).item(0)).getTextContent().replace(",", ".")));
                    break;
                default:
                    break;
            }

        }
        return currency;
    }
}
