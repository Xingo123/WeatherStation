package sample;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Xing on 19-3-2016.
 */
abstract class WeatherData
{
    abstract void getMaxTemperature() throws IOException, JSONException;

    abstract void getMinTemperature() throws IOException, JSONException;

    abstract void getHumidity() throws IOException, JSONException;

    abstract void getWindInstance() throws IOException, JSONException;
}
