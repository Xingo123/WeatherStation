package weatherStation.AdapterPattern;

import org.json.JSONException;
import weatherStation.WeatherStation;

import java.io.IOException;

/**
 * Created by Xing on 19-3-2016.
 */
public class OpenWeatherApi extends WeatherData
{
    //Fields OpenWeatherApi
    private JsonReader jsonReader;

    //OpenWeatherApi Constructor assign the city to the json
    public OpenWeatherApi(String city) throws IOException, JSONException
    {
        jsonReader  = new JsonReader(city);
    }

    /*
        Getting maximum Temperature of the day
     */
    public String getMaxTemperature() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getMaxTemp());
    }

    /*
        Getting minimum Temperature of the day
     */
    public String getMinTemperature() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getMinTemp());
    }

    /*
        Getting humidity of the day
     */
    public String getHumidity() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getHumidity());
    }

    /*
        Getting wind instance of the day
     */
    public String getWindInstance() throws IOException, JSONException
    {
        return String.valueOf(jsonReader.getWindInstance());
    }

    /*
       Getting the main description of the current moment
    */
    public String getWeatherDescription() throws IOException, JSONException
    {
        return jsonReader.getDescription();
    }

    /*
        Get current assigned city
     */
    public String getCity() throws IOException, JSONException
    {
        return jsonReader.getCity();
    }

    /*
        The forecast method from JsonReader
     */
    public String getForecast1() throws IOException, JSONException
    {
        return jsonReader.getForecast1();
    }

    /*
        The forecast method from JsonReader
     */
    public String getForecast2() throws IOException, JSONException
    {
        return jsonReader.getForecast2();
    }
}
