package sample;

/**
 * Created by Xing on 3-4-2016.
 */
public class RainyWeather implements Decorator
{
    @Override
    public String getURL()
    {
        return "Rainy";
    }
}
