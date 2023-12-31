package com.codewithmosh.facade;

public class Demo {
  public static void show() {
    var twitter = new TwitterFacade("key", "secret");
    var tweets = twitter.getRecentTweets();
  }
}
