package weatherStation.DecoratorPattern;

/**
 * Created by Xing &amp; Selami on 4-4-2016.
 * The decorater station is the main class to get all subclasses together and
 * eventually it will be a part of the WeatherStation Main Class
 */
public class DecoratorStation
{
    //Fields type of decorator
    private Decorator cloudyWeather;
    private Decorator rainyWeather;
    private Decorator sunnyWeather;
    private Decorator brokenCloudsWeather;
    private Decorator clearWeather;
    private Decorator scatteredThunderstormWeather;
    
    //String description uses to get store the current weather description of the API's
    private String description;

    //Constructor Decorator station creating all kinds of weather
    public DecoratorStation(String currentWeatherDescription)
    {
        cloudyWeather = new CloudyWeather();
        rainyWeather = new RainyWeather();
        sunnyWeather = new SunnyWeather();
        brokenCloudsWeather = new BrokenCloudsWeather();
        clearWeather = new ClearWeather();
        scatteredThunderstormWeather = new ScatteredThunderstorms();
        this.description = currentWeatherDescription;
    }

    /*
        Return broken clouds weather url string
     */
    public String getBrokenCloudsWeather()
    {
        return brokenCloudsWeather.getURL();
    }

    /*
        Return clear weather url string
     */
    public String getClearWeather()
    {
        return clearWeather.getURL();
    }

    /*
        Return Scattered Thumderstorms weather url string
     */
    public String getScatteredThunderstormWeather()
    {
        return scatteredThunderstormWeather.getURL();
    }

    /*
        Return cloudy weather url string
     */
    public String getCloudyWeather()
    {
        return cloudyWeather.getURL();
    }

    /*
        Return rainy weather
     */
    public String getRainyWeather()

    {
        return rainyWeather.getURL();
    }


    /*
        Return Sunny weather
    */
    public String getSunnyWeather()
    {
        return sunnyWeather.getURL();
    }

    /*
        Comparing description to the existing description of OpenWeatherApi
        Returns a image string path
     */
    public String getImageUrlOpen()
    {
        String temp = "";
        if(description.equals("Clouds"))
        {
            temp = getCloudyWeather();
        }
        else if(description.equals("Sunny"))
        {
            temp = getSunnyWeather();
        }
        else if(description.equals("Rain"))
        {
            temp = getRainyWeather();
        }
        else if(description.equals("Showers"))
        {
            temp = getRainyWeather();
        }
        else if(description.equals("Clear"))
        {
            temp = getClearWeather();
        }
        else if(description.equals("broken clouds"))
        {
            temp = getBrokenCloudsWeather();
        }
        else
        {
            temp = "file:src/img/stenden.png";
        }

        return temp;
    }

    /*
        Comparing description to the existing description of YahooApi
        Returns a image string path
     */
    public String getImageUrlYahoo()
    {
        String temp = "";
        System.out.println(description);
        if(description.equals("Cloudy"))
        {
            temp = getCloudyWeather();
        }
        else if(description.equals("Partly Cloudy"))
        {
            temp = getCloudyWeather();
        }
        else if(description.equals("Broken Clouds"))
        {
            temp = getBrokenCloudsWeather();
        }
        else if(description.equals("Clear"))
        {
            temp = getClearWeather();
        }
        else if(description.equals("Sunny"))
        {
            temp = getSunnyWeather();
        }
        else if(description.equals("Rain"))
        {
            temp = getRainyWeather();
        }
        else if(description.equals("Scattered Thunderstorms"))
        {
            temp = getScatteredThunderstormWeather();
        }
        else
        {
            temp = "file:src/img/stenden.png";
        }

        return temp;
    }
}
