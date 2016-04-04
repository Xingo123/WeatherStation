package weatherStation.DecoratorPattern;

/**
 * Created by Xing on 4-4-2016.
 */
public class DecoratorStation
{
    private Decorator cloudyWeather;
    private Decorator rainyWeather;
    private Decorator sunnyWeather;
    private String description;

    public DecoratorStation(String currentWeatherDescription)
    {
        cloudyWeather = new CloudyWeather();
        rainyWeather = new RainyWeather();
        sunnyWeather = new SunnyWeather();
        this.description = currentWeatherDescription;
    }

    public String getCloudyWeather()
    {
        return cloudyWeather.getURL();
    }

    public String getRainyWeather()
    {
        return rainyWeather.getURL();
    }

    public String getSunnyWeather()
    {
        return sunnyWeather.getURL();
    }

    public String getImageUrlOpen()
    {
        String temp = "";
        System.out.println(description);
        if(description.equals("Clouds"))
        {
            temp = "file:src/img/cloudy.gif";
        }
        else if(description.equals("Sunny"))
        {
            temp = "file:src/img/giphy.gif";
        }
        else if(description.equals("Rainy"))
        {
            temp = "file:src/img/rainy.gif";
        }
        else if(description.equals("Clear"))
        {
            temp = "file:src/img/clearsky.jpg";
        }
        else if(description.equals("broken clouds"))
        {
            temp = "file:src/img/brokenclouds.gif";
        }
        else
        {
            temp = "file:src/img/stenden.png";
        }

        return temp;
    }

    public String getImageUrlYahoo()
    {
        String temp = "";
        System.out.println(description);
        if(description.equals("Cloudy"))
        {
            temp = "file:src/img/cloudy.gif";
        }
        else if(description.equals("Partly Cloudy"))
        {
            temp = "file:src/img/cloudy.gif";
        }
        else if(description.equals("Broken Clouds"))
        {
            temp = "file:src/img/brokenclouds.gif";
        }
        else if(description.equals("Clear"))
        {
            temp = "file:src/img/clearsky.gif";
        }
        else if(description.equals("Sunny"))
        {
            temp = "file:src/img/giphy.gif";
        }
        else if(description.equals("Rain"))
        {
            temp = "file:src/img/rainy.gif";
        }
        else if(description.equals("Scattered Thunderstorms"))
        {
            temp = "file:src/img/Scattered Thunderstorms.gif";
        }
        else
        {
            temp = "file:src/img/stenden.png";
        }

        return temp;
    }
}
