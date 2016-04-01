package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Weather Station");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        
        WeatherStation weatherStation = new WeatherStation();

        weatherStation.getYahooApi().getMinTemperature();
        weatherStation.getYahooApi().getMinTemperature();
        weatherStation.getYahooApi().getHumidity();
        weatherStation.getYahooApi().getWeatherDescription();
        weatherStation.getYahooApi().getWindInstance();

        weatherStation.getOpenWeatherApi().getMinTemperature();
        weatherStation.getOpenWeatherApi().getMinTemperature();
        weatherStation.getOpenWeatherApi().getHumidity();
        weatherStation.getOpenWeatherApi().getWeatherDescription();
        weatherStation.getOpenWeatherApi().getWindInstance();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
