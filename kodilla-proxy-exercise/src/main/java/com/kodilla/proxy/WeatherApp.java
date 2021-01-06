package com.kodilla.proxy;

import com.kodilla.proxy.db.LazyWeatherDataRetrieverProxy;
import com.kodilla.proxy.db.WeatherDataRetrieverDb;

import java.util.Random;

public class WeatherApp {
    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();

        for (int n = 0; n < 5; n++) {
//            WeatherDataRetrieverDb weatherDataRetriever = new WeatherDataRetriever();
            WeatherDataRetrieverDb weatherDataRetriever = new LazyWeatherDataRetrieverProxy();
            int number = new Random().nextInt(100);
            if (number < 20)
                System.out.println(weatherDataRetriever.refreshData());
            else if (number < 30)
                System.out.println(weatherDataRetriever.getWeather());
            System.out.println("Execution #" + n + " just finished");
        }

        long end = System.currentTimeMillis();
        System.out.println("The execution took: " + (end - begin) + " [ms]");
    }
}
