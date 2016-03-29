package sample;

import org.json.JSONException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by Xing on 29-3-2016.
 */
public class WeatherStation
{
    public WeatherData yahooApiWeather() throws JAXBException, IOException
    {
        WeatherData yahooApi = new YahooWeatherApi();

        return yahooApi;
    }

    public WeatherData openWeatherApi() throws IOException, JSONException
    {
        WeatherData openWeatherApi = new OpenWeatherApi();

        return openWeatherApi;
    }

    // When 'Zoek' is pressed on the GUI | For testing purposes
    public void setYahooWeatherApi() throws JAXBException, IOException
    {
        yahooApiWeather();
    }

    public void setOpenWeatherApi() throws IOException, JSONException
    {
        openWeatherApi();
    }
}