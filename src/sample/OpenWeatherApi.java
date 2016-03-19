package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;

/**
 * Created by Xing on 19-3-2016.
 */
public class OpenWeatherApi extends WeatherData
{
    private JsonReader jsonReader = new JsonReader();
    void getMaxTemperature() throws IOException
    {
        System.out.println(jsonReader.getMaxTemp());
    }

    void getMinTemperature() throws IOException
    {
        System.out.println(jsonReader.getMinTemp());
    }

    void getHumidity() throws IOException
    {
        System.out.println(jsonReader.getHumidity());
    }

    void getWindInstance() throws IOException
    {
        System.out.println(jsonReader.getWindInstance());
    }
}
