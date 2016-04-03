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
    public YahooWeatherApi(String city) throws JAXBException, IOException, ParserConfigurationException, SAXException
    {
        xmlReader = new XMLReader(city);
    }

    String getMaxTemperature() throws IOException, JSONException
    {
        return xmlReader.getMaxTemperature();
    }

    String getMinTemperature() throws IOException, JSONException
    {
        return xmlReader.getMinTemperature();
    }

    String getHumidity() throws IOException, JSONException
    {
        return xmlReader.getHumidity();
    }

    String getWindInstance() throws IOException, JSONException
    {
        return xmlReader.getWind();
    }

    String getWeatherDescription() throws IOException, JSONException
    {
        return xmlReader.getDescription();
    }

    String getCity() throws IOException, JSONException
    {
        return xmlReader.getCity();
    }

    String getForecast1() throws IOException, JSONException
    {
        return xmlReader.getForecast1();
    }

    String getForecast2() throws IOException, JSONException
    {
        return xmlReader.getForecast2();
    }
}
