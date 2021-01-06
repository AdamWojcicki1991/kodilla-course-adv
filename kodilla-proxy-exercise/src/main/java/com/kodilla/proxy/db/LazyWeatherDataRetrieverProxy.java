package com.kodilla.proxy.db;

public class LazyWeatherDataRetrieverProxy implements WeatherDataRetrieverDb {
    private WeatherDataRetrieverDb retriever;

    @Override
    public String getWeather() throws InterruptedException {
        if (retriever == null)
            retriever = new WeatherDataRetriever();
        return retriever.getWeather();
    }

    @Override
    public String refreshData() throws InterruptedException {
        if (retriever == null)
            retriever = new WeatherDataRetriever();
        return retriever.refreshData();
    }
}
