package sample;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import com.github.fedy2.weather.YahooWeatherService;
import com.github.fedy2.weather.data.*;
import com.github.fedy2.weather.data.unit.DegreeUnit;
import org.json.JSONException;

/**
 * Created by Xing on 19-3-2016.
 */
public class XMLReader
{
    private YahooWeatherService service = new YahooWeatherService();
    // 729104 = Emmen
    private Channel channel = service.getForecast("729104", DegreeUnit.CELSIUS);

    public XMLReader() throws JAXBException, IOException {
        System.out.println(channel.getDescription());
        //System.out.println(channel.getItem().getDescription());
        //System.out.println(channel.getLocation());
        //System.out.println(channel.getUnits());
        //System.out.println(channel.getWind());
        //System.out.println(channel.getAtmosphere());
        //System.out.println(channel.getAstronomy());
    }

    /**
     *  Temperature:
     *  item > condition > temp
     */
    public int getTemperature() throws IOException, JSONException
    {
        return channel.getItem().getCondition().getTemp();
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
    public Astronomy getAstronomy() throws IOException, JSONException
    {
        return channel.getAstronomy();
    }
}
