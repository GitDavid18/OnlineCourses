package com.codewithmoshDemos.observer;

public class SpreadSheet implements Observer {
  private DataSource dataSource;

  public SpreadSheet(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void update() {
    System.out.println("SpreadSheet got notified: " + dataSource.getValue());
  }
}
