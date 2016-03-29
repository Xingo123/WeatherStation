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

    public YahooWeatherApi() throws JAXBException, IOException, JSONException, ParserConfigurationException, SAXException
    {
        getMaxTemperature();
        getMinTemperature();
        getHumidity();
        getWindInstance();
        getWeatherDescription();
    }

    void getMaxTemperature() throws IOException, JSONException
    {
        System.out.println("Max Temp: " + xmlReader.getTemperature());
    }

    void getMinTemperature() throws IOException, JSONException
    {
        System.out.println("Min Temp: " + xmlReader.getTemperature());
    }

    void getHumidity() throws IOException, JSONException
    {
        System.out.println("Humidity: " + xmlReader.getHumidity());
    }

    void getWindInstance() throws IOException, JSONException
    {
        System.out.println("Wind speed: " + xmlReader.getWind());
    }

    void getWeatherDescription() throws IOException, JSONException
    {
        System.out.println("Description: " + xmlReader.getDescription());
    }
}
