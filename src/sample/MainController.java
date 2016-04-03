package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.event.WindowEvent;
import java.io.IOException;
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
            e.printStackTrace();
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
            System.out.println(e.getMessage());
        }
    }

    public void showWeatherData(ActionEvent event) throws IOException, JSONException
    {
        JsonReader json = new JsonReader();
        json.setCity(searchField.getText());
        cityLabel.setText(searchField.getText());

        System.out.println(searchField.getText());
    }

    public void radioSelected(ActionEvent event) throws IOException, ParserConfigurationException, SAXException, JSONException, JAXBException
    {
        if (rb1.isSelected())
        {
            System.out.println("Radio Button 1");
            openWeather();
        }
        if (rb2.isSelected())
        {
            System.out.println("Radio Button 2");
            yahooWeather();
        }
    }

    public void openWeather() throws IOException, ParserConfigurationException, SAXException, JSONException, JAXBException
    {
        weatherStation = new WeatherStation();
        minTempLabel.setText(weatherStation.getOpenWeatherApi().getMinTemperature());
        maxTempLabel.setText(weatherStation.getOpenWeatherApi().getMaxTemperature());
        humidityLabel.setText(weatherStation.getOpenWeatherApi().getHumidity());
        pressureLabel.setText(weatherStation.getOpenWeatherApi().getWindInstance());
        cityLabel.setText(weatherStation.getOpenWeatherApi().getCity());
        descrLabel.setText(weatherStation.getOpenWeatherApi().getWeatherDescription());
        forecastLabel1.setText(weatherStation.getOpenWeatherApi().getForecast1());
        forecastLabel2.setText(weatherStation.getOpenWeatherApi().getForecast2());
    }

    public void yahooWeather() throws IOException, JSONException, JAXBException, ParserConfigurationException, SAXException
    {
        weatherStation = new WeatherStation();
        minTempLabel.setText(weatherStation.getYahooApi().getMinTemperature());
        maxTempLabel.setText(weatherStation.getYahooApi().getMaxTemperature());
        humidityLabel.setText(weatherStation.getYahooApi().getHumidity());
        pressureLabel.setText(weatherStation.getYahooApi().getWindInstance());
        cityLabel.setText(weatherStation.getYahooApi().getCity());
        descrLabel.setText(weatherStation.getYahooApi().getWeatherDescription());
        forecastLabel1.setText(weatherStation.getYahooApi().getForecast1());
        forecastLabel2.setText(weatherStation.getYahooApi().getForecast2());
    }
}
