package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;

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

        /**
        weatherStation.getYahooApi().getMinTemperature();
        weatherStation.getYahooApi().getMaxTemperature();
        weatherStation.getYahooApi().getHumidity();
        weatherStation.getYahooApi().getWindInstance();
        weatherStation.getYahooApi().getWeatherDescription();
         */

        //weatherStation.getOpenWeatherApi().getMinTemperature();
        //weatherStation.getOpenWeatherApi().getMaxTemperature();
        //weatherStation.getOpenWeatherApi().getHumidity();
        //weatherStation.getOpenWeatherApi().getWindInstance();
        //weatherStation.getOpenWeatherApi().getWeatherDescription();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
