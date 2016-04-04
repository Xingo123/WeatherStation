package weatherStation.DecoratorPattern;

/**
 * Created by Xing on 3-4-2016.
 */
public class CloudyWeather implements Decorator
{
    @Override
    public String getURL()
    {
        return "test";
    }
}
