package weatherStation.ObserverPattern;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Xing on 1-4-2016.
 */
public interface ObserverSubject
{
    void registerObserver(WeatherObserver o);
    void removeObserver(WeatherObserver o);
    void notifyObservers() throws IOException, JSONException;
}
