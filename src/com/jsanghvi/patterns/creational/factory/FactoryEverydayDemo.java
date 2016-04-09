package com.jsanghvi.patterns.creational.factory;

import java.util.Calendar;

public class FactoryEverydayDemo {
    public static void main(String args[]) {
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1);
        System.out.println(Calendar.DAY_OF_MONTH);
    }
}
