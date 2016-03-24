package sample;

import org.json.JSONException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by Selami on 24-3-2016.
 */
public class Observer
{
    public WeatherData yahooApiWeather() throws JAXBException, IOException, JSONException
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
    public void setYahooWeatherApi() throws JSONException, JAXBException, IOException
    {
        yahooApiWeather();
    }

    public void setOpenWeatherApi() throws IOException, JSONException
    {
        openWeatherApi();
    }

    public void setTemperature()
    {

    }

    public void setHumidity()
    {

    }

    public void setWind()
    {

    }
}
