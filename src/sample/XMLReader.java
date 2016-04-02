package sample;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by Xing on 19-3-2016.
 */
public class XMLReader
{
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;
    private NodeList nList;
    private Node nNode;


    public XMLReader() throws JAXBException, IOException, ParserConfigurationException, SAXException
    {
        dbFactory = DocumentBuilderFactory.newInstance();
        dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text=%22Coevorden%22)");
    }

    /**
     * Temperature
     */
    public String getTemperature() throws IOException, JSONException
    {
        nList = doc.getElementsByTagName("yweather:condition");
        nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getAttribute("temp");
    }

    /**
     * Humidity
     */
    public String getHumidity() throws IOException, JSONException
    {
        nList = doc.getElementsByTagName("yweather:atmosphere");
        nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getAttribute("humidity");
    }

    /**
     * Wind
     */
    public String getWind() throws IOException, JSONException
    {
        nList = doc.getElementsByTagName("yweather:atmosphere");
        nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getAttribute("pressure");
    }

    /**
     * Description
     */
    public String getDescription() throws IOException, JSONException
    {
        nList = doc.getElementsByTagName("yweather:condition");
        nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getAttribute("text");
    }

    /**
     * City
     */
    public String getCity() throws IOException, JSONException
    {
        nList = doc.getElementsByTagName("title");
        nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getTextContent();
    }
}
