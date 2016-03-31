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
    public WeatherData yahooApi;
    public WeatherData openWeatherApi;

    public WeatherStation() throws IOException, SAXException, ParserConfigurationException
    {
        yahooApi = new YahooWeatherApi();
        openWeatherApi = new OpenWeatherApi();
    }

    public void setYahooWeatherApi() throws JAXBException, IOException
    {
        //yahooApiWeather();
    }

    public void setOpenWeatherApi() throws IOException, JSONException
    {
        //openWeatherApi();
    }
}
