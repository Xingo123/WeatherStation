package sample;

import javax.xml.bind.JAXBException;
import javax.xml.bind.ParseConversionEvent;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Xing on 29-3-2016.
 */
public class YahooParser
{
    private YahooRetriever yahooRetriever;
    private static String query;

    public YahooParser() throws JAXBException
    {
        query = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"Coevorden, NL\")";
        yahooRetriever = new YahooRetriever();
    }


    public String getString() throws Exception
    {
        return yahooRetriever.getURL(query);
    }
}
