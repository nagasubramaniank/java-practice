package com.jsanghvi.patterns.creational.builder;

public class BuilderEverydayDemo {
    public static void main(String args[]) {
        StringBuilder string = new StringBuilder();

        string.append("This is an example of builder pattern.");
        string.append(" We can insert almost anything we want to a String.");
        string.append(42);

        System.out.println(string.toString());
    }
}
