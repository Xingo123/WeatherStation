package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Weather Station  ");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        WeatherData owm = new OpenWeatherApi();
        owm.getMaxTemperature();
        System.out.println(" ");
        owm.getMinTemperature();
        System.out.println(" ");
        owm.getHumidity();
        System.out.println(" ");
        owm.getWindInstance();
        System.out.println(" ");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
