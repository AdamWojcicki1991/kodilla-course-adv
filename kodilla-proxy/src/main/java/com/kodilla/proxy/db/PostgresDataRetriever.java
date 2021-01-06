package com.kodilla.proxy.db;

public class PostgresDataRetriever implements DbDataRetriever {

    public PostgresDataRetriever() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Override
    public int getFirstValue() {
        return 100;
    }

    @Override
    public int getSecondValue() {
        return 200;
    }

    @Override
    public int getThirdValue() {
        return 300;
    }
}
