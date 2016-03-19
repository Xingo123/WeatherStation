package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
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
        System.out.println(jsonReader.getMaxTemp());
    }

    void getMinTemperature() throws IOException, JSONException
    {
        System.out.println(jsonReader.getMinTemp());
    }

    void getHumidity() throws IOException, JSONException
    {
        System.out.println(jsonReader.getHumidity());
    }

    void getWindInstance() throws IOException, JSONException
    {
        System.out.println(jsonReader.getWindInstance());
    }
}
