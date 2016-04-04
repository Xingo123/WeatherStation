package weatherStation.AdapterPattern;

import org.json.JSONException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Xing on 19-3-2016.
 */
public class YahooWeatherApi extends WeatherData
{
    /*
        Fields of YahooWeatherApi
        That uses an XMLReader object to read data
     */
    private XMLReader xmlReader;

    /*
        Constructor of XMLReader
        Creating a new object XMLReader
     */
    public YahooWeatherApi(String city) throws JAXBException, IOException, ParserConfigurationException, SAXException
    {
        xmlReader = new XMLReader(city);
    }

    /*
        Getting maximum Temperature of the day
     */
    public String getMaxTemperature() throws IOException, JSONException
    {
        return xmlReader.getMaxTemperature();
    }

    /*
        Getting minimum Temperature of the day
     */
    public String getMinTemperature() throws IOException, JSONException
    {
        return xmlReader.getMinTemperature();
    }

    /*
        Getting humidity of the day
     */
    public String getHumidity() throws IOException, JSONException
    {
        return xmlReader.getHumidity();
    }

    /*
        Getting wind instance of the day
     */
    public String getWindInstance() throws IOException, JSONException
    {
        return xmlReader.getWind();
    }

    /*
       Getting the main description of the current moment
    */
    public String getWeatherDescription() throws IOException, JSONException
    {
        return xmlReader.getDescription();
    }

    /*
        Get current assigned city
     */
    public String getCity() throws IOException, JSONException
    {
        return xmlReader.getCity();
    }

    /*
        The forecast method from XMLReader
     */
    public String getForecast1() throws IOException, JSONException
    {
        return xmlReader.getForecast1();
    }

    /*
        The forecast method from XMLReader
     */
    public String getForecast2() throws IOException, JSONException
    {
        return xmlReader.getForecast2();
    }
}
