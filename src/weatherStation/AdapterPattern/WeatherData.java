package weatherStation.AdapterPattern;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Xing & Selami on 19-3-2016.
 * An Abstract Factory class that controls all functions of the WeatherStation
 *
 */
public abstract class WeatherData
{
    public abstract String getMaxTemperature() throws IOException, JSONException;

    public abstract String getMinTemperature() throws IOException, JSONException;

    public abstract String getHumidity() throws IOException, JSONException;

    public abstract String getWindInstance() throws IOException, JSONException;

    public abstract String getWeatherDescription() throws IOException, JSONException;

    public abstract String getCity() throws IOException, JSONException;

    public abstract String getForecast1() throws IOException, JSONException;

    public abstract String getForecast2() throws IOException, JSONException;
}
