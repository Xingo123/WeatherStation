package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.event.WindowEvent;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import org.json.JSONException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Selami on 2-4-2016.
 */
public class MainController implements Initializable
{
    @FXML
    Label minTempLabel;

    @FXML
    Label maxTempLabel;

    @FXML
    Label humidityLabel;

    @FXML
    Label pressureLabel;

    @FXML
    Label cityLabel;

    @FXML
    Label descrLabel;

    @FXML
    Label forecastLabel1;

    @FXML
    Label forecastLabel2;

    @FXML
    TextField searchField;

    @FXML
    RadioButton rb1;

    @FXML
    RadioButton rb2;

    private WeatherStation weatherStation;

    private String city;

    public MainController()
    {
        this.city = "Coevorden";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        try
        {
            openWeather();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();System.out.println("io");
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            try
            {
                openWeather();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
            catch (ParserConfigurationException e1)
            {
                e1.printStackTrace();
            }
            catch (SAXException e1)
            {
                e1.printStackTrace();
            }
            catch (JAXBException e1)
            {
                e1.printStackTrace();
            }
            System.out.println(e.getMessage());
        }
    }

    public void showWeatherData(ActionEvent event) throws IOException, JSONException, JAXBException, SAXException, ParserConfigurationException
    {
        this.city = searchField.getText();
        System.out.println(city);
        radioSelected(event);
    }

    public void radioSelected(ActionEvent event) throws IOException, ParserConfigurationException, SAXException, JSONException, JAXBException
    {
        if (rb1.isSelected())
        {
            System.out.println("Radio Button 1");
            try
            {
                openWeather();
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();System.out.println("io");
            }
            catch (SAXException e)
            {
                e.printStackTrace();
            }
            catch (JAXBException e)
            {
                e.printStackTrace();
            }
            catch (ParserConfigurationException e)
            {
                e.printStackTrace();
            }
            catch (NullPointerException e)
            {
                try
                {
                    openWeather();
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                catch (ParserConfigurationException e1)
                {
                    e1.printStackTrace();
                }
                catch (SAXException e1)
                {
                    e1.printStackTrace();
                }
                catch (JAXBException e1)
                {
                    e1.printStackTrace();
                }
                System.out.println(e.getMessage());
            }
        }
        if (rb2.isSelected())
        {
            System.out.println("Radio Button 2");
            try
            {
                yahooWeather();
            }
            catch (SAXException e)
            {
                e.printStackTrace();
                System.out.println("sax");
            }
            catch (JAXBException e)
            {
                e.printStackTrace();System.out.println("jax");
            }
            catch (ParserConfigurationException e)
            {
                e.printStackTrace();
                System.out.println("testP");
            }
            catch (NullPointerException e)
            {
                try
                {
                    yahooWeather();
                }
                catch (ParserConfigurationException e1)
                {
                    e1.printStackTrace();
                }
                catch (SAXException e1)
                {
                    e1.printStackTrace();
                }
                catch (JAXBException e1)
                {
                    e1.printStackTrace();
                }
                System.out.println(e.getMessage());
            }
        }
    }

    public void openWeather() throws IOException, ParserConfigurationException, SAXException, JSONException, JAXBException
    {
        weatherStation = new WeatherStation(city);
        minTempLabel.setText(weatherStation.getOpenWeatherApi().getMinTemperature());
        maxTempLabel.setText(weatherStation.getOpenWeatherApi().getMaxTemperature());
        humidityLabel.setText(weatherStation.getOpenWeatherApi().getHumidity());
        pressureLabel.setText(weatherStation.getOpenWeatherApi().getWindInstance());
        cityLabel.setText(weatherStation.getOpenWeatherApi().getCity());
        descrLabel.setText(weatherStation.getOpenWeatherApi().getWeatherDescription());
        forecastLabel1.setText(weatherStation.getOpenWeatherApi().getForecast1());
        forecastLabel2.setText(weatherStation.getOpenWeatherApi().getForecast2());

        System.out.println("open");
    }

    public void yahooWeather() throws IOException, JSONException, JAXBException, ParserConfigurationException, SAXException
    {
        weatherStation = new WeatherStation(city);
        minTempLabel.setText(weatherStation.getYahooApi().getMinTemperature());
        maxTempLabel.setText(weatherStation.getYahooApi().getMaxTemperature());
        humidityLabel.setText(weatherStation.getYahooApi().getHumidity());
        pressureLabel.setText(weatherStation.getYahooApi().getWindInstance());
        cityLabel.setText(weatherStation.getYahooApi().getCity());
        descrLabel.setText(weatherStation.getYahooApi().getWeatherDescription());
        forecastLabel1.setText(weatherStation.getYahooApi().getForecast1());
        forecastLabel2.setText(weatherStation.getYahooApi().getForecast2());

        System.out.println("yahoo");
    }
}
