package sample;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

import java.io.IOException;

import org.json.JSONException;

import java.net.MalformedURLException;

/**
 * Created by Xing on 19-3-2016.
 */
public class JsonReader
{ // declaring object of "OpenWeatherMap" class
    private OpenWeatherMap owm = new OpenWeatherMap("0ff3dd96a6e1b885e7d66ec896b71860");
    // getting current weather data for the "Coevorden" city
    private String city = "Coevorden";

    public float getMaxTemp() throws IOException, JSONException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);

        return getTemperatureInCelcius(cwd.getMainInstance().getMaxTemperature());
    }

    public float getMinTemp() throws IOException, JSONException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);

        return getTemperatureInCelcius(cwd.getMainInstance().getMinTemperature());
    }

    public float getHumidity() throws IOException, JSONException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);

        return cwd.getMainInstance().getHumidity();
    }

    public float getWindInstance() throws IOException, JSONException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);

        return cwd.getMainInstance().getPressure();
    }

    public float getTemperatureInCelcius(float temp)
    {
        temp = ((temp - 32) * 5) / 9;

        return temp;
    }

    public String getDescription() throws IOException, JSONException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);

        return cwd.getWeatherInstance(0).getWeatherName();
    }
}
