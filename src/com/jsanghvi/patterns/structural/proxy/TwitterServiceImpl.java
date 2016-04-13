package com.jsanghvi.patterns.structural.proxy;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

class TwitterServiceImpl implements TwitterService {
    private static final String TWITTER_CONSUMER_KEY = "TWITTER_CONSUMER_KEY";
    private static final String TWITTER_SECRET = "TWITTER_SECRET";
    private static final String TWITTER_ACCESS_TOKEN = "TWITTER_ACCESS_TOKEN";
    private static final String TWITTER_ACCESS_TOKEN_SECRET = "TWITTER_ACCESS_TOKEN_SECRET";

    @Override
    public String getTimeline(String screenName) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
                .setOAuthConsumerSecret(TWITTER_SECRET)
                .setOAuthAccessToken(TWITTER_ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(TWITTER_ACCESS_TOKEN_SECRET);

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        StringBuilder sb = new StringBuilder();

        try {
            Query query = new Query(screenName);
            int numTweets = 0;
            for (QueryResult result = twitter.search(query); numTweets < 100 && query != null; query = result.nextQuery()) {
                List<Status> tweets = result.getTweets();
                numTweets += tweets.size();
                tweets.forEach(tweet -> sb.append("@")
                        .append(tweet.getUser().getScreenName())
                        .append(" - ")
                        .append(tweet.getText())
                        .append("\n"));
            }
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }

        return sb.toString();
    }

    @Override
    public void postToTimeline(String screenName, String message) {
        // Security proxy will not allow call to this function.
        System.out.println(message);
    }
}
