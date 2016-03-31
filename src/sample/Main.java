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
        yahooApi.getMinTemperature();

        System.out.println(" ");

//        WeatherData owm = new OpenWeatherApi();
//        owm.getMinTemperature();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
