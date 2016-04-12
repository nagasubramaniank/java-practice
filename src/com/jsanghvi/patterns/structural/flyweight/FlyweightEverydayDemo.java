package com.jsanghvi.patterns.structural.flyweight;

class FlyweightEverydayDemo {
    public static void main(String[] args) {
        Integer integer1 = 5;
        Integer integer2 = 10;
        Integer integer3 = 5; // Returns cached class object.

        System.out.println(System.identityHashCode(integer1));
        System.out.println(System.identityHashCode(integer2));
        System.out.println(System.identityHashCode(integer3));
    }
}
