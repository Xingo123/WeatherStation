package weatherStation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONException;
import org.xml.sax.SAXException;
import weatherStation.DecoratorPattern.CloudyWeather;
import weatherStation.DecoratorPattern.Decorator;
import weatherStation.DecoratorPattern.DecoratorStation;
import weatherStation.DecoratorPattern.SunnyWeather;
import weatherStation.ObserverPattern.WeatherObserver;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Selami on 2-4-2016.
 */
public class MainController implements Initializable
{
    //Fields FXML
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

    @FXML
    ImageView imageViewer;

    //Fields MainController

    //
    private WeatherStation weatherStation;

    private String city;

    private WeatherObserver weatherObserver;

    private DecoratorStation decoratorStation;

    private String weatherDescr;

    /*
        assign a standard city to the variable city
        and create a new WeatherObserver object.
     */
    public MainController() throws IOException, ParserConfigurationException, SAXException, JAXBException
    {
        this.city = "Coevorden";
        weatherObserver = new WeatherObserver()
        {
            @Override
            public String update()
            {
                return weatherDescr;
            }
        };
        //weatherStation.registerObserver(weatherObserver);
    }

    /*
        Initialize the Weather with a call Standard call is openWeather
     */
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
            catch (NullPointerException e1)
            {
                System.out.println(e1.getMessage());
            }
            catch (JSONException e1)
            {
                e1.printStackTrace();
            }
            System.out.println(e.getMessage());
        }
    }

    /*
        Function that triggers the inputfield and accessor the current city
     */
    public void showWeatherData(ActionEvent event) throws IOException, JSONException, JAXBException, SAXException, ParserConfigurationException
    {
        this.city = searchField.getText();
        radioSelected(event);
    }

    /*
        RadioSelected function that switches between the API's
     */
    public void radioSelected(ActionEvent event) throws IOException, ParserConfigurationException, SAXException, JSONException, JAXBException
    {
        if (rb1.isSelected())
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
                catch (NullPointerException e1)
                {
                    System.out.println(e1.getMessage());
                }
                System.out.println(e.getMessage());
            }
        }
        if (rb2.isSelected())
        {
            try
            {
                yahooWeather();
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
                catch (NullPointerException e1)
                {
                    System.out.println(e1.getMessage());
                }
                System.out.println(e.getMessage());
            }
        }
    }

    /*
        Call the OpenWeatherApi, assign with city variable that been filled from the inputfield
        Assignen data to labels
     */
    public void openWeather() throws IOException, JSONException, ParserConfigurationException, SAXException, JSONException, JAXBException
    {

        weatherStation = new WeatherStation(city);
        this.weatherDescr = weatherStation.getOpenWeatherApi().getWeatherDescription();

        //assign the decoratorStation with the description from the WeatherObserver
        decoratorStation = new DecoratorStation(weatherObserver.update());

        minTempLabel.setText(weatherStation.getOpenWeatherApi().getMinTemperature());
        maxTempLabel.setText(weatherStation.getOpenWeatherApi().getMaxTemperature());
        humidityLabel.setText(weatherStation.getOpenWeatherApi().getHumidity());
        pressureLabel.setText(weatherStation.getOpenWeatherApi().getWindInstance());
        cityLabel.setText(weatherStation.getOpenWeatherApi().getCity());
        descrLabel.setText(weatherDescr);
        forecastLabel1.setText(weatherStation.getOpenWeatherApi().getForecast1());
        forecastLabel2.setText(weatherStation.getOpenWeatherApi().getForecast2());

        //Create temp img variable, assign it with the image url path from the decorator class
        Image img = null;
        img = new Image(decoratorStation.getImageUrlOpen());

        imageViewer.setImage(img);
    }

    /*
       Call the YahooWeatherApi, assign with city variable that been filled from the inputfield
       Assignen data to labels
    */
    public void yahooWeather() throws IOException, JSONException, JAXBException, ParserConfigurationException, SAXException
    {
        weatherStation = new WeatherStation(city);
        weatherDescr = weatherStation.getYahooApi().getWeatherDescription();

        //assign the decoratorStation with the description from the WeatherObserver
        decoratorStation = new DecoratorStation(weatherObserver.update());

        minTempLabel.setText(weatherStation.getYahooApi().getMinTemperature());
        maxTempLabel.setText(weatherStation.getYahooApi().getMaxTemperature());
        humidityLabel.setText(weatherStation.getYahooApi().getHumidity());
        pressureLabel.setText(weatherStation.getYahooApi().getWindInstance());
        cityLabel.setText(weatherStation.getYahooApi().getCity());
        descrLabel.setText(weatherDescr);
        forecastLabel1.setText(weatherStation.getYahooApi().getForecast1());
        forecastLabel2.setText(weatherStation.getYahooApi().getForecast2());

        //Create temp img variable, assign it with the image url path from the decorator class
        Image img = null;
        img = new Image(decoratorStation.getImageUrlYahoo());

        imageViewer.setImage(img);
    }
}
