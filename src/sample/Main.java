package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.JSONException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Weather Station");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        setYahooWeather();
        System.out.println(" ");
        setOpenWeather();

    }

    public static void main(String[] args)
    {
        launch(args);
    }

    public WeatherData setYahooWeather() throws JSONException, JAXBException, IOException, ParserConfigurationException, SAXException
    {
        WeatherStation yahooApi = new WeatherStation();
        return yahooApi.yahooApiWeather();
    }

    public WeatherData setOpenWeather() throws IOException, JSONException
    {
        WeatherStation openWeatherApi = new WeatherStation();
        return openWeatherApi.openWeatherApi();
    }


}
