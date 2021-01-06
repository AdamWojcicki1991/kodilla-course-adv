package com.kodilla.proxy.db;

public class WeatherDataRetriever implements WeatherDataRetrieverDb {

    public WeatherDataRetriever() throws InterruptedException {
        refreshData();
    }

    @Override
    public String getWeather() {
        return "Weather forecast for today will by sunny!";
    }

    @Override
    public String refreshData() throws InterruptedException {
        Thread.sleep(5000);
        return "Weather forecast for today changed and now is rainy!";
    }
}
