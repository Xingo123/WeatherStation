package weatherStation.AdapterPattern;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by Xing on 19-3-2016.
 */
public class XMLReader
{
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;
    private NodeList nList;
    private Node nNode;
    private String city;


    public XMLReader(String city) throws JAXBException, IOException, ParserConfigurationException, SAXException
    {
        this.city = city;
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text=%22" + city + "%22)&format=xml");
    }

    /**
     * Temperature
     */
    public String getMaxTemperature() throws IOException, JSONException
    {
        nList = doc.getElementsByTagName("yweather:forecast");
        nNode = nList.item(0);
        Element element = (Element) nNode;

        return getTemperatureInCelcius(Float.parseFloat(element.getAttribute("high")));
    }

    /**
     * Temperature
     */
    public String getMinTemperature() throws IOException, JSONException
    {
        nList = doc.getElementsByTagName("yweather:forecast");
        nNode = nList.item(0);
        Element element = (Element) nNode;

        return getTemperatureInCelcius(Float.parseFloat(element.getAttribute("low")));
    }

    /**
     * Humidity
     */
    public String getHumidity() throws IOException, JSONException
    {
        nList = doc.getElementsByTagName("yweather:atmosphere");
        nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getAttribute("humidity");
    }

    /**
     * Wind
     */
    public String getWind() throws IOException, JSONException
    {
        nList = doc.getElementsByTagName("yweather:atmosphere");
        nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getAttribute("pressure");
    }

    /**
     * Description
     */
    public String getDescription() throws IOException, JSONException
    {
        nList = doc.getElementsByTagName("yweather:condition");
        nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getAttribute("text");
    }

    /**
     * City
     */
    public String getCity() throws IOException, JSONException
    {
        nList = doc.getElementsByTagName("title");
        nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getTextContent();
    }

    /** DONT DELETE
    public String getForecast() throws IOException, JSONException
    {
        String forecastString = null;
        nList = doc.getElementsByTagName("yweather:forecast");

        for (int i = 1; i < nList.getLength(); i++)
        {
            nNode = nList.item(i);
            Element element = (Element) nNode;

            forecastString += element.getAttribute("day") + " " + element.getAttribute("date") + "\n" +
                    "Min: " + element.getAttribute("low") + "\n" +
                    "Max: " + element.getAttribute("high") + "\n" +
                    element.getAttribute("text") + "\n\n";
        }
        return forecastString;
    }
     */

    // 2 seperate methods for 2 days each. 2 seperate labels
    public String getForecast1() throws IOException, JSONException
    {
        String forecastString = "";
        nList = doc.getElementsByTagName("yweather:forecast");

        for (int i = 1; i < 3; i++)
        {
            nNode = nList.item(i);
            Element element = (Element) nNode;

            forecastString += element.getAttribute("day") + " " + element.getAttribute("date") + "\n" +
                    "Min: " + getTemperatureInCelcius(Float.parseFloat(element.getAttribute("low"))) + "\n" +
                    "Max: " + getTemperatureInCelcius(Float.parseFloat(element.getAttribute("high"))) + "\n" +
                    element.getAttribute("text") + "\n\n";
        }
        return forecastString;
    }

    public String getForecast2() throws IOException, JSONException
    {
        String forecastString = "";
        nList = doc.getElementsByTagName("yweather:forecast");

        for (int i = 3; i < 5; i++)
        {
            nNode = nList.item(i);
            Element element = (Element) nNode;

            forecastString += element.getAttribute("day") + " " + element.getAttribute("date") + "\n" +
                    "Min: " + getTemperatureInCelcius(Float.parseFloat(element.getAttribute("low"))) + "\n" +
                    "Max: " + getTemperatureInCelcius(Float.parseFloat(element.getAttribute("high"))) + "\n" +
                    element.getAttribute("text") + "\n\n";
        }
        return forecastString;
    }

    /*
        Convert Fahrenheit temperature to Celcius
     */
    public String getTemperatureInCelcius(float temp)
    {

        temp = ((temp - 32) * 5) / 9;

        return Float.toString(temp);
    }
}
