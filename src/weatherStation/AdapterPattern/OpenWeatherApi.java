package weatherStation.AdapterPattern;

import org.json.JSONException;
import weatherStation.WeatherStation;

import java.io.IOException;

/**
 * Created by Xing on 19-3-2016.
 */
public class OpenWeatherApi extends WeatherData
{
    private JsonReader jsonReader;

    public OpenWeatherApi(String city) throws IOException, JSONException
    {
        jsonReader  = new JsonReader(city);
    }

    public String getMaxTemperature() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getMaxTemp());
    }

    public String getMinTemperature() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getMinTemp());
    }

    public String getHumidity() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getHumidity());
    }

    public String getWindInstance() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getWindInstance());
    }

    public String getWeatherDescription() throws IOException, JSONException
    {
        return jsonReader.getDescription();
    }

    public String getCity() throws IOException, JSONException
    {
        return jsonReader.getCity();
    }

    public String getForecast1() throws IOException, JSONException
    {
        return jsonReader.getForecast1();
    }

    public String getForecast2() throws IOException, JSONException
    {
        return jsonReader.getForecast2();
    }
}
