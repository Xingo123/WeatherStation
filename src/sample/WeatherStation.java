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
    //Fields Weatherstation class
    private WeatherData yahooApi;
    private WeatherData openWeatherApi;

    /*
        Constructor of Weather station
        Where the WeatherData class uses his child classes
     */
    public WeatherStation() throws JSONException, JAXBException, IOException, ParserConfigurationException, SAXException
    {
        yahooApi = new YahooWeatherApi();
        openWeatherApi = new OpenWeatherApi();
    }

    public WeatherData getYahooWeatherApi()
    {
        return yahooApi;
    }

    public WeatherData getOpenWeatherApi()
    {
        return openWeatherApi;
    }
}
