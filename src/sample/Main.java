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

        WeatherData yahooApi = new YahooWeatherApi();
        yahooApi.getMaxTemperature();
        yahooApi.getMinTemperature();
        yahooApi.getHumidity();
        yahooApi.getWindInstance();
        yahooApi.getWeatherDescription();

        System.out.println(" ");

        WeatherData openWeatherApi = new OpenWeatherApi();
        openWeatherApi.getMaxTemperature();
        openWeatherApi.getMinTemperature();
        openWeatherApi.getHumidity();
        openWeatherApi.getWindInstance();
        openWeatherApi.getWeatherDescription();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
