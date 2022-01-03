package com.codewithmosh.observer;

import java.util.ArrayList;
import java.util.List;

public class StockListView implements Observer{
    private List<Stock> stocks = new ArrayList<>();

    public void addStock(Stock stock)
    {
        stocks.add(stock);
        stock.addObserver(this);
    }

    public void show() {
        for (var stock : stocks)
            System.out.println(stock);
    }

    @Override
    public void update() {
        System.out.println("Prices have changed, updating StockListView");
        show();
    }
}
