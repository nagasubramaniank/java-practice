package com.jsanghvi.patterns.structural.proxy;

interface TwitterService {
    String getTimeline(String screenName);

    void postToTimeline(String screenName, String message);
}

