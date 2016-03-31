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
    private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    private Document doc;

    public XMLReader() throws ParserConfigurationException, IOException, SAXException
    {
        doc = dBuilder.parse("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Emmen%2C%20NL%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys");
    }

    /**
     *  Temperature
     */
    protected String getTemperature()
    {
        NodeList nList = doc.getElementsByTagName("yweather:condition");
        Node nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getAttribute("temp");
    }

    /**
     *  Humidity
     */
    protected String getHumidity()
    {
        NodeList nList = doc.getElementsByTagName("yweather:atmosphere");
        Node nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getAttribute("humidity");
    }

    /**
     *  Wind
     */
    protected String getWind()
    {
        NodeList nList = doc.getElementsByTagName("yweather:atmosphere");
        Node nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getAttribute("pressure");
    }

    /**
     *  Description
     */
    protected String getDescription()
    {
        NodeList nList = doc.getElementsByTagName("yweather:condition");
        Node nNode = nList.item(0);
        Element element = (Element) nNode;

        return element.getAttribute("text");
    }
}
