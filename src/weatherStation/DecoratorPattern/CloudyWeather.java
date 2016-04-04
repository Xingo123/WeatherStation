package weatherStation.DecoratorPattern;

/**
 * Created by Xing & Selami on 4-4-2016.
 * This is an abstract subclass that returns an url image path
 */
public class CloudyWeather implements Decorator
{
    @Override
    public String getURL()
    {
        return "file:src/img/cloudy.gif";
    }
}
