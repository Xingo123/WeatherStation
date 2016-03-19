package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.json.JSONException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by Xing on 19-3-2016.
 */
public class YahooWeatherApi extends WeatherData
{
    private XMLReader xmlReader = new XMLReader();

    public YahooWeatherApi() throws JAXBException, IOException {
    }

    void getMaxTemperature() throws IOException, JSONException
    {
        System.out.println(xmlReader.getUnits());
    }

    void getMinTemperature() throws IOException, JSONException
    {
        System.out.println(xmlReader.getUnits());
    }

    void getHumidity() throws IOException, JSONException
    {
        System.out.println(xmlReader.getAtmosphere());
    }

    void getWindInstance() throws IOException, JSONException
    {
        System.out.println(xmlReader.getWind());
    }
}
