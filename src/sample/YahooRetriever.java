package sample;

import java.net.URLEncoder;
import java.util.logging.Logger;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Xing on 29-3-2016.
 */
public class YahooRetriever
{
    private String BASE_URL = "http://query.yahooapis.com/v1/public/yql";

    private static Logger logger = Logger.getLogger(String.valueOf(YahooRetriever.class));

    public InputStream retrieve(String query) throws Exception
    {
        logger.info("YEAAAH");
        String url = BASE_URL + "?q=" + URLEncoder.encode(query,"UTF-8") + "&format=xml";

        URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }

    public String getURL(String query) throws Exception
    {
        String url = BASE_URL + "?q=" + URLEncoder.encode(query,"UTF-8") + "&format=xml";

        return url;
    }
}
