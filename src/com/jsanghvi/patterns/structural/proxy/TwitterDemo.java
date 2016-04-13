package com.jsanghvi.patterns.structural.proxy;

class TwitterDemo {
    public static void main(String[] args) {
        TwitterService service = (TwitterService) SecurityProxy.newInstance(new TwitterServiceImpl());

        System.out.println(service.getTimeline("narendramodi"));

        service.postToTimeline("jatin085", "Some message that shouldn't go through.");
    }
}
