package com.jsanghvi.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeEverydayDemo {
    public static void main(String args[]) {
        String query = "SELECT * FROM Movies WHERE title = ?";
        List<String> parameters = new ArrayList<>();
        parameters.add("Star Wars");
        Record record = new Record();

        Statement statement1 = new Statement(query, parameters, record);
        System.out.println(statement1.getQuery());
        System.out.println(statement1.getParameters());
        System.out.println(statement1.getRecord());

        Statement statement2 = statement1.clone();
        System.out.println(statement2.getQuery());
        System.out.println(statement2.getParameters());
        System.out.println(statement2.getRecord());
    }
}
