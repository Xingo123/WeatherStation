package weatherStation.AdapterPattern;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;

import java.io.IOException;

import org.json.JSONException;

/**
 * Created by Xing on 19-3-2016.
 */
public class JsonReader
{ // declaring object of "OpenWeatherMap" class
    private OpenWeatherMap owm = new OpenWeatherMap("0ff3dd96a6e1b885e7d66ec896b71860");
    private DailyForecast df;

    // getting current weather data for the "Coevorden" city
    private String city;

    public JsonReader(String city) throws IOException, JSONException
    {
        this.city = setCity(city);
        df = owm.dailyForecastByCityName(city + ", NL", Byte.parseByte("5"));
    }

    /*
        Getting maximum Temperature of the day
     */
    public float getMaxTemp() throws IOException, JSONException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);

        return getTemperatureInCelcius(cwd.getMainInstance().getMaxTemperature());
    }

    /*
        Getting minimum Temperature of the day
     */
    public float getMinTemp() throws IOException, JSONException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);

        return getTemperatureInCelcius(cwd.getMainInstance().getMinTemperature());
    }

    /*
        Getting humidity of the day
     */
    public float getHumidity() throws IOException, JSONException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);

        return cwd.getMainInstance().getHumidity();
    }

    /*
        Getting wind instance of the day
     */
    public float getWindInstance() throws IOException, JSONException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);

        return cwd.getMainInstance().getPressure();
    }

    /*
        Convert Fahrenheit temperature to Celcius
     */
    public float getTemperatureInCelcius(float temp)
    {
        temp = ((temp - 32) * 5) / 9;

        return temp;
    }

    /*
        Getting the main description of the current moment
     */
    public String getDescription() throws IOException, JSONException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);

        return cwd.getWeatherInstance(0).getWeatherName();
    }

    public String getCity() throws IOException, JSONException
    {
        CurrentWeather cwd = owm.currentWeatherByCityName(city);

        return cwd.getCityName();
    }

    /** DONT DELETE
    public String getForecast() throws IOException, JSONException
    {
        String forecastString = null;
        for (int i = 1; i < df.getForecastCount(); i++)
        {
            DailyForecast.Forecast forecast = df.getForecastInstance(i);
            forecastString += forecast.getDateTime() + "\n Min: \t\t" + getTemperatureInCelcius(forecast.getTemperatureInstance().getMinimumTemperature()) + "\n Max: \t\t" +
                    getTemperatureInCelcius(forecast.getTemperatureInstance().getMaximumTemperature()) + "\n Humidity: \t" +
                    forecast.getHumidity() + "\n Pressure: \t" +
                    forecast.getPressure() + "\n\n";
        }
        return forecastString;
    }
     */

    // 2 seperate methods for 2 days each. 2 seperate labels
    public String getForecast1() throws IOException, JSONException
    {
        String forecastString = "";
        for (int i = 1; i < 3; i++)
        {
            DailyForecast.Forecast forecast = df.getForecastInstance(i);
            forecastString += forecast.getDateTime() + "\n Min: \t\t" + getTemperatureInCelcius(forecast.getTemperatureInstance().getMinimumTemperature()) + "\n Max: \t\t" +
                             getTemperatureInCelcius(forecast.getTemperatureInstance().getMaximumTemperature()) + "\n Humidity: \t" +
                             forecast.getHumidity() + "\n Pressure: \t" +
                             forecast.getPressure() + "\n\n";
        }
        return forecastString;
    }

    public String getForecast2() throws IOException, JSONException
    {
        String forecastString = "";
        for (int i = 3; i < 5; i++)
        {
            DailyForecast.Forecast forecast = df.getForecastInstance(i);
            forecastString += forecast.getDateTime() + "\n Min: \t\t" + getTemperatureInCelcius(forecast.getTemperatureInstance().getMinimumTemperature()) + "\n Max: \t\t" +
                    getTemperatureInCelcius(forecast.getTemperatureInstance().getMaximumTemperature()) + "\n Humidity: \t" +
                    forecast.getHumidity() + "\n Pressure: \t" +
                    forecast.getPressure() + "\n\n";
        }
        return forecastString;
    }

    public String setCity(String city)
    {
        this.city = city;
        return city;
    }
}
