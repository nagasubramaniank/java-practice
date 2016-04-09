package com.jsanghvi.patterns.creational.prototype;

public class PrototypeDemo {
    public static void main(String args[]) {
        Registry registry = new Registry();

        Movie movie1 = (Movie) registry.createItem("Movie");
        movie1.setTitle("Star Wars");
        System.out.println(movie1);
        System.out.println(movie1.getTitle());
        System.out.println(movie1.getRuntime());
        System.out.println(movie1.getUrl());
        System.out.println(movie1.getPrice());

        Movie movie2 = (Movie) registry.createItem("Movie");
        movie2.setTitle("Star Trek");
        System.out.println(movie2);
        System.out.println(movie2.getTitle());
        System.out.println(movie2.getRuntime());
        System.out.println(movie2.getUrl());
        System.out.println(movie2.getPrice());
    }
}
