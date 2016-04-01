package sample;

import java.io.IOException;

/**
 * Created by Xing on 1-4-2016.
 */
public interface ObserverSubject
{
    public void registerObserver(WeatherObserver o);
    public void removeObserver(WeatherObserver o);
    public void notifyObservers() throws IOException;
}
