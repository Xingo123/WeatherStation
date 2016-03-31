package sample;

import net.aksingh.owmjapis.AbstractWeather;
import org.json.JSONException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Xing on 29-3-2016.
 */
public class WeatherStation
{
    /*
        Fields of WheaterStation
        All fields are the type of WeatherData
     */
    private WeatherData yahooApi;
    private WeatherData openWeatherApi;

    /*
        Constructor of WheaterStation
        Assign an API Source to the WeatherData object
     */
    public WeatherStation() throws JSONException, JAXBException, IOException, ParserConfigurationException, SAXException
    {
        yahooApi = new YahooWeatherApi();
        openWeatherApi = new OpenWeatherApi();
    }

    /*
        Getting the sourcedata of the object YahooWeatherApi
     */
    public WeatherData getYahooApi()
    {
        return yahooApi;
    }

    /*
        Getting the sourcedata of the object OpenWeatherApi
     */
    public WeatherData getOpenWeatherApi()
    {
        return openWeatherApi;
    }
}
