package sample;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Xing on 19-3-2016.
 */
public class OpenWeatherApi extends WeatherData
{
    private JsonReader jsonReader = new JsonReader();

    String getMaxTemperature() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getMaxTemp());
    }

    String getMinTemperature() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getMinTemp());
    }

    String getHumidity() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getHumidity());
    }

    String getWindInstance() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getWindInstance());
    }

    String getWeatherDescription() throws IOException, JSONException
    {
        return jsonReader.getDescription();
    }

    String getCity() throws IOException, JSONException
    {
        return jsonReader.getCity();
    }
}
