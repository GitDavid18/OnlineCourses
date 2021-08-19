package com.codewithmosh.observer;

public class observer_main {
    public static void main(String[] args) {
        Stock A = new Stock("Sun", 1000);
        Stock B = new Stock("Moon", 10);

        StatusBar statusBar = new StatusBar();
        StockListView stockListView = new StockListView();

        statusBar.addStock(A);
        statusBar.addStock(B);
        stockListView.addStock(A);
        stockListView.addStock(B);

        System.out.println("Changing price for A");
        A.setPrice(500);
        System.out.println("Changing price for B");
        B.setPrice(25);
    }
}
