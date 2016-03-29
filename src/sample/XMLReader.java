package sample;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by Xing on 19-3-2016.
 */
public class XMLReader
{
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    // Emmen
    Document doc = dBuilder.parse("https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text=%22Coevorden%22)");


    public XMLReader() throws JAXBException, IOException, ParserConfigurationException, SAXException { }

    /**
     *  Temperature
     */
    public Integer getTemperature() throws IOException, JSONException
    {
        NodeList nList = doc.getElementsByTagName("yweather:condition");
        Node nNode = nList.item(0);
        org.w3c.dom.Element element = (org.w3c.dom.Element) nNode;

        return Integer.parseInt(element.getAttribute("temp"));
    }

    /**
     *  Humidity
     */
    public Integer getHumidity() throws IOException, JSONException
    {
        NodeList nList = doc.getElementsByTagName("yweather:atmosphere");
        Node nNode = nList.item(0);
        org.w3c.dom.Element element = (org.w3c.dom.Element) nNode;

        return Integer.parseInt(element.getAttribute("humidity"));
    }

    /**
     *  Wind
     */
    public Integer getWind() throws IOException, JSONException
    {
        NodeList nList = doc.getElementsByTagName("yweather:wind");
        Node nNode = nList.item(0);
        org.w3c.dom.Element element = (org.w3c.dom.Element) nNode;

        return Integer.parseInt(element.getAttribute("speed"));
    }

    /**
     *  Description
     */
    public String getDescription() throws IOException, JSONException
    {
        NodeList nList = doc.getElementsByTagName("yweather:condition");
        Node nNode = nList.item(0);
        org.w3c.dom.Element element = (org.w3c.dom.Element) nNode;

        return element.getAttribute("text");
    }
}
