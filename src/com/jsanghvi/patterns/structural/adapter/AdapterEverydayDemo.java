package com.jsanghvi.patterns.structural.adapter;

import java.util.Arrays;
import java.util.List;

class AdapterEverydayDemo {
    public static void main(String args[]) {
        Integer[] integerArray = new Integer[]{42, 43, 44};
        List<Integer> integerList = Arrays.asList(integerArray);

        System.out.println(Arrays.toString(integerArray));
        System.out.println(integerList);
    }
}
