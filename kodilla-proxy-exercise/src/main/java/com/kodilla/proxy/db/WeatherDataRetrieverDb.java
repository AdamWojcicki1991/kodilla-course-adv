package com.kodilla.proxy.db;

public interface WeatherDataRetrieverDb {
    String getWeather() throws InterruptedException;

    String refreshData() throws InterruptedException;
}
