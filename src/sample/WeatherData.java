package sample;

import java.io.IOException;

/**
 * Created by Xing on 19-3-2016.
 */
abstract class WeatherData
{
    abstract void getMaxTemperature() throws IOException;

    abstract void getMinTemperature() throws IOException;

    abstract void getHumidity() throws IOException;

    abstract void getWindInstance() throws IOException;
}
