package sample;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.*;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import com.github.fedy2.weather.data.unit.Time;
import org.json.JSONException;

/**
 * Created by Xing on 19-3-2016.
 */
public class XMLReader
{
    private YahooWeatherService service = new YahooWeatherService();
    // 7824 Zip Code
    private Channel channel = service.getForecast("7824", DegreeUnit.CELSIUS);

    public XMLReader() throws JAXBException, IOException {
        System.out.println(channel.getDescription());
        //System.out.println(channel.getLocation());
        //System.out.println(channel.getUnits());
        //System.out.println(channel.getWind());
        //System.out.println(channel.getAtmosphere());
        //System.out.println(channel.getAstronomy());
    }

    /**
     *  Units:
     *  Distance, pressure, speed, temperature
     */
    public DegreeUnit getUnits() throws IOException, JSONException
    {
        return channel.getUnits().getTemperature();
    }

    /**
     *  Atmosphere:
     *  Humidity, pressure, rising, visibility
     */
    public Integer getAtmosphere() throws IOException, JSONException
    {
        return channel.getAtmosphere().getHumidity();
    }

    /**
     *  Wind:
     *  Chill, direction, speed
     */
    public Integer getWind() throws IOException, JSONException
    {
        return channel.getWind().getDirection();
    }

    /**
     *  Astronomy:
     *  Sunrise, sunset
     */
    public Time getAstronomy() throws IOException, JSONException
    {
        return channel.getAstronomy().getSunrise();
    }

    /**public void getService() throws JAXBException, IOException
    {

    }*/
}
