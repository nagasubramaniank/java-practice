package com.jsanghvi.patterns.structural.decorator;

class SimpleSandwich implements Sandwich {
    @Override
    public String make() {
        return "Bread";
    }
}
