package com.codewithmosh.facade;

import java.util.List;

public class TwitterFacade {

    private final String appKey;
    private final String appSecret;

    public TwitterFacade(String appKey, String appSecret){

        this.appKey = appKey;
        this.appSecret = appSecret;
    }
    public List<Tweet> getRecentTweets(){

        var twitterClient = new TwitterClient();
        return twitterClient.getRecentTweets(GetAccessToken());
    }

    private String GetAccessToken(){
        var oauth = new OAuth();
        var requestToken = oauth.requestToken(appKey, appSecret);
        return oauth.getAccessToken(requestToken);
    }
}
