package sample;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Xing on 19-3-2016.
 */
public class OpenWeatherApi extends WeatherData
{
    private JsonReader jsonReader = new JsonReader();

    void getMaxTemperature() throws IOException, JSONException
    {
        System.out.println("Max Temp: " + jsonReader.getMaxTemp());
    }

    void getMinTemperature() throws IOException, JSONException
    {
        System.out.println("Min Temp: " + jsonReader.getMinTemp());
    }

    void getHumidity() throws IOException, JSONException
    {
        System.out.println("Humidity: " + jsonReader.getHumidity());
    }

    void getWindInstance() throws IOException, JSONException
    {
        System.out.println("Wind pressure: " + jsonReader.getWindInstance());
    }

    String getWeatherDescription() throws IOException, JSONException
    {
        return jsonReader.getDescription();
    }
}
