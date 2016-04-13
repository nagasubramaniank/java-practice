package com.jsanghvi.patterns.structural.proxy;

class TwitterServiceStub implements TwitterService {

    @Override
    public String getTimeline(String screenName) {
        return "My neat twitter timeline.";
    }

    @Override
    public void postToTimeline(String screenName, String message) {
        // Security proxy will not allow call to this function.
        System.out.println(message);
    }
}
