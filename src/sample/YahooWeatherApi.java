package sample;

import org.json.JSONException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Xing on 19-3-2016.
 */
public class YahooWeatherApi extends WeatherData
{
    private XMLReader xmlReader = new XMLReader();

    public YahooWeatherApi() throws ParserConfigurationException, SAXException, IOException
    {
    }

    void getMaxTemperature()
    {
        System.out.println(xmlReader.getTemperature());
    }

    void getMinTemperature()
    {
        System.out.println(xmlReader.getTemperature());
    }

    void getHumidity()
    {
        System.out.println(xmlReader.getHumidity());
    }

    void getWindInstance()
    {
        System.out.println(xmlReader.getWind());
    }

    void getWeatherDescription()
    {
        System.out.println(xmlReader.getDescription());
    }
}
