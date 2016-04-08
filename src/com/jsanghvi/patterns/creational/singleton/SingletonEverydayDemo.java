package com.jsanghvi.patterns.creational.singleton;

public class SingletonEverydayDemo {
    public static void main(String args[]) {
        Runtime runtime1 = Runtime.getRuntime();
        runtime1.gc();

        Runtime runtime2 = Runtime.getRuntime();

        if (runtime1 == runtime2) {
            System.out.println("Runtime object is a singleton.");
        }
    }
}
