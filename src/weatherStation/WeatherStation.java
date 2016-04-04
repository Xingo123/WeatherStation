package weatherStation;

import org.json.JSONException;
import org.xml.sax.SAXException;
import weatherStation.AdapterPattern.OpenWeatherApi;
import weatherStation.AdapterPattern.WeatherData;
import weatherStation.AdapterPattern.YahooWeatherApi;
import weatherStation.ObserverPattern.ObserverSubject;
import weatherStation.ObserverPattern.WeatherObserver;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Xing on 29-3-2016.
 */
public class WeatherStation implements ObserverSubject
{
    /*
        Fields of WheaterStation
        All fields are the type of WeatherData
     */
    public WeatherData yahooApi;
    public WeatherData openWeatherApi;
    private ArrayList observers;

    /*
        Constructor of WheaterStation
        Assign an API Source to the WeatherData object
     */
    public WeatherStation(String city) throws JSONException, JAXBException, IOException, ParserConfigurationException, SAXException
    {
        yahooApi = new YahooWeatherApi(city);
        openWeatherApi = new OpenWeatherApi(city);
        observers = new ArrayList();
    }

    /*
        Getting the sourcedata of the object YahooWeatherApi
     */
    public WeatherData getYahooApi()
    {
        return yahooApi;
    }

    /*
        Getting the sourcedata of the object OpenWeatherApi
     */
    public WeatherData getOpenWeatherApi()
    {
        return openWeatherApi;
    }

    @Override
    public void registerObserver(WeatherObserver o)
    {
        try
        {
            observers.add(o);
        }
        catch(ArrayStoreException e)
        {
            System.out.println(e);
        }
    }

    @Override
    public void removeObserver(WeatherObserver o)
    {
        int i = observers.indexOf(o);
        if (i >= 0)
        {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() throws IOException, JSONException
    {
        for (int i = 0; i < observers.size(); i++)
        {
            WeatherObserver observer = (WeatherObserver)observers.get(i);
            if(yahooApi.getWeatherDescription() == "")
            {
                observer.update();
            }
            else
            {
                observer.update();
            }
        }
    }
}
