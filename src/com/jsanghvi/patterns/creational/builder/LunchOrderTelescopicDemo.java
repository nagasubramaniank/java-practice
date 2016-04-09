package com.jsanghvi.patterns.creational.builder;

public class LunchOrderTelescopicDemo {
    public static void main(String args[]) {
        LunchOrderTelescopic lunchOrderTelescopic = new LunchOrderTelescopic("Wheat", "Lettuce", "Mustard", "Ham");

        System.out.println(lunchOrderTelescopic.getBread());
        System.out.println(lunchOrderTelescopic.getCondiments());
        System.out.println(lunchOrderTelescopic.getDressing());
        System.out.println(lunchOrderTelescopic.getMeat());
    }
}
