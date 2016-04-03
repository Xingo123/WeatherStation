package sample;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Xing on 19-3-2016.
 */
abstract class WeatherData
{
    abstract String getMaxTemperature() throws IOException, JSONException;

    abstract String getMinTemperature() throws IOException, JSONException;

    abstract String getHumidity() throws IOException, JSONException;

    abstract String getWindInstance() throws IOException, JSONException;

    abstract String getWeatherDescription() throws IOException, JSONException;

    abstract String getCity() throws IOException, JSONException;

    abstract String getForecast1() throws IOException, JSONException;

    abstract String getForecast2() throws IOException, JSONException;
}
