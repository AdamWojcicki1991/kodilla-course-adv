package com.kodilla.proxy.db;

public class LazyDataRetrieverProxy implements DbDataRetriever {
    private DbDataRetriever retriever;

    @Override
    public int getFirstValue() throws InterruptedException {
        if (retriever == null)
            retriever = new PostgresDataRetriever();
        return retriever.getFirstValue();
    }

    @Override
    public int getSecondValue() throws InterruptedException {
        if (retriever == null)
            retriever = new PostgresDataRetriever();
        return retriever.getSecondValue();
    }

    @Override
    public int getThirdValue() throws InterruptedException {
        if (retriever == null)
            retriever = new PostgresDataRetriever();
        return retriever.getThirdValue();
    }
}
