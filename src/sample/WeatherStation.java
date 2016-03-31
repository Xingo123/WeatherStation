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
    private WeatherData yahooApi;
    private WeatherData openWeatherApi;

    public WeatherStation() throws JSONException, JAXBException, IOException, ParserConfigurationException, SAXException
    {
        yahooApi = new YahooWeatherApi();
        openWeatherApi = new OpenWeatherApi();

    }

    // When 'Zoek' is pressed on the GUI | For testing purposes
    public void setYahooWeatherApi() throws JAXBException, IOException
    {
        //yahooApiWeather();
    }

    public void setOpenWeatherApi() throws IOException, JSONException
    {
        //openWeatherApi();
    }
}
