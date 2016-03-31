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
    /*
        Fields of YahooWeatherApi
        That uses an XMLReader object to read data
     */
    private XMLReader xmlReader;

    /*
        Constructor of XMLReader
        Creating a new object XMLReader
     */
    public YahooWeatherApi() throws JAXBException, IOException, ParserConfigurationException, SAXException
    {
        xmlReader = new XMLReader();
    }

    void getMaxTemperature() throws IOException
    {
        System.out.println("Max Temp: " + xmlReader.getTemperature());
    }

    void getMinTemperature() throws IOException
    {
        System.out.println("Min Temp: " + xmlReader.getTemperature());
    }

    void getHumidity() throws IOException
    {
        System.out.println("Humidity: " + xmlReader.getHumidity());
    }

    void getWindInstance() throws IOException
    {
        System.out.println("Wind speed: " + xmlReader.getWind());
    }

    void getWeatherDescription() throws IOException
    {
        System.out.println("Description: " + xmlReader.getDescription());
    }
}
