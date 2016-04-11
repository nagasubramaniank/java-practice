package com.jsanghvi.patterns.structural.decorator;

abstract class SandwichDecorator implements Sandwich {
    private final Sandwich customSandwich;

    public SandwichDecorator(Sandwich customSandwich) {
        this.customSandwich = customSandwich;
    }

    @Override
    public String make() {
        return customSandwich.make();
    }
}
